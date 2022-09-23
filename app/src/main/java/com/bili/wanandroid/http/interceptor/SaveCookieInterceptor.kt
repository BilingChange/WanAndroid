package com.bili.wanandroid.http.interceptor

import com.bili.wanandroid.http.HttpConstant
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @description:保存Cookie参数拦截器
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    20:29.
 **/
class SaveCookieInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        val requestUrl = request.url.toString()
        val domain = request.url.host
        // set-cookie maybe has multi, login to save cookie
        if ((requestUrl.contains(HttpConstant.SAVE_USER_LOGIN_KEY)
                    || requestUrl.contains(HttpConstant.SAVE_USER_REGISTER_KEY))
            && response.headers(HttpConstant.SET_COOKIE_KEY).isNotEmpty()
        ) {
            val cookies = response.headers(HttpConstant.SET_COOKIE_KEY)
            val cookie = HttpConstant.encodeCookie(cookies)
            HttpConstant.saveCookie(requestUrl, domain, cookie)
        }
        return response
    }
}