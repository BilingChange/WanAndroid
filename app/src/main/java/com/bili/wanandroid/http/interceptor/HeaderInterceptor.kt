package com.bili.wanandroid.http.interceptor

import com.bili.base.utils.SharePreferenceUtils
import com.bili.wanandroid.http.HttpConstant
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @description:请求头拦截器
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    20:29.
 **/
class HeaderInterceptor : Interceptor {

    private var token: String by SharePreferenceUtils(HttpConstant.TOKEN_KEY, "")

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()

        builder.addHeader("Content-type", "application/json; charset=utf-8")
        val domain = request.url.host
        val url = request.url.toString()
        if (domain.isNotEmpty() && (url.contains(HttpConstant.COLLECTIONS_WEBSITE)
                    || url.contains(HttpConstant.UN_COLLECTIONS_WEBSITE)
                    || url.contains(HttpConstant.ARTICLE_WEBSITE)
                    || url.contains(HttpConstant.TODO_WEBSITE)
                    || url.contains(HttpConstant.COIN_WEBSITE))
        ) {
            val spDomain: String by SharePreferenceUtils(domain, "")
            val cookie: String = spDomain.ifEmpty { "" }
            if (cookie.isNotEmpty()) {
                // 将 Cookie 添加到请求头
                builder.addHeader(HttpConstant.COOKIE_NAME, cookie)
            }
        }
        return chain.proceed(builder.build())
    }

}