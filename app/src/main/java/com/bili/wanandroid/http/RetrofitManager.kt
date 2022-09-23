package com.bili.wanandroid.http

import com.bili.base.BaseApp.Companion.context
import com.bili.wanandroid.BuildConfig
import com.bili.wanandroid.http.cookies.CookieManager
import com.bili.wanandroid.http.interceptor.HeaderInterceptor
import com.bili.wanandroid.http.interceptor.SaveCookieInterceptor
import com.bili.wanandroid.services.ApiService
import com.bili.wanandroid.services.BaseService
import com.bili.wanandroid.utils.SystemUtil
import com.qisan.baselib.utils.FileUtil
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.security.KeyStore
import java.security.cert.CertificateFactory
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager


/**
 * @description:Retrofit 管理类
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    21:09.
 **/

/**
 * SSLSocketFactory
 */
private var sslSocketFactory: SSLSocketFactory? = null

/**
 * X509TrustManager
 */
private var trustManager: X509TrustManager? = null

/**
 * BaseService 集合
 */
private val servicesMap = ConcurrentHashMap<String, BaseService>()

/**
 * ApiService 接口实例
 */
val apiService: ApiService by lazy {
    retrofit.create(ApiService::class.java)
}

/**
 * 创建Retrofit实例
 */
val retrofit: Retrofit by lazy {
    Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(HttpConstant.BASE_URL)
        .build()
}

/**
 * 创建业务接口实例
 * @param serviceClass 接口service
 */
fun <K : BaseService> getService(serviceClass: Class<K>): K {
    return servicesMap.getOrPut(serviceClass.name) {
        retrofit.create(serviceClass)
    } as K
}

/**
 * 创建业务接口实例
 * @param serviceClass 接口service
 * @param baseUrl 接口地址
 */
fun <K : BaseService> getService(serviceClass: Class<K>, baseUrl: String? = null): K {
    return servicesMap.getOrPut(serviceClass.name) {
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(HttpConstant.BASE_URL)
            .build()
            .create(serviceClass)
    } as K
}

/**
 * OkHttpClient
 */
private val okHttpClient: OkHttpClient by lazy {
    val builder = OkHttpClient.Builder()
        .addInterceptor(getHttpLoggingInterceptor())
        .addInterceptor(HeaderInterceptor())
        .addInterceptor(SaveCookieInterceptor())
        .cookieJar(CookieManager())
        .connectTimeout(HttpConstant.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(HttpConstant.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(HttpConstant.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
    builder.build()
}

/**
 * 获取拦截器
 */
private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    if (BuildConfig.DEBUG) {
        interceptor.level = HttpLoggingInterceptor.Level.BODY
    } else {
        interceptor.level = HttpLoggingInterceptor.Level.NONE
    }
    return interceptor
}

/**
 * 模拟的ssl签名添加
 */
private fun initSslContext() {
    var inputStream: InputStream? = null
    try {
        // 取到证书的输入流
        inputStream = ByteArrayInputStream(FileUtil.readBinaryFileContent(context.assets.open("ssl_config.txt")))

        val certificateFactory = CertificateFactory.getInstance("X.509")
        val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
        keyStore.load(null, null)
        val certificates = certificateFactory.generateCertificates(inputStream)
        for ((index, certificate) in certificates.withIndex()) {
            val certificateAlias = index.toString()
            keyStore.setCertificateEntry(certificateAlias, certificate)
        }
        // 使用包含自签名证书的 KeyStore 构建一个 X509TrustManager
        val trustManagerFactory =
            TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        trustManagerFactory.init(keyStore)
        val trustManagers = trustManagerFactory.trustManagers
        check(!(trustManagers.size != 1 || trustManagers[0] !is X509TrustManager)) {
            ("Unexpected default trust managers:" + Arrays.toString(trustManagers))
        }
        // 使用 X509TrustManager 初始化 SSLContext
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, trustManagers, null)
        sslSocketFactory = sslContext.socketFactory
        trustManager = trustManagers[0] as X509TrustManager
    } catch (e: Exception) {
    } finally {
        if (inputStream != null) {
            SystemUtil.closeQuietly(inputStream)
        }
    }
}
