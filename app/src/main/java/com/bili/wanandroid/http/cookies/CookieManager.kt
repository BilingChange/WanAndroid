package com.bili.wanandroid.http.cookies

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

/**
 * @description:Cookie管理器
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    20:16.
 **/
class CookieManager : CookieJar {

    /**
     * 保存Cookie文件
     */
    private val COOKIE_STORE = PersistentCookieStore()

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        if (cookies.isNotEmpty()) {
            for (cookie in cookies) {
                COOKIE_STORE.add(url, cookie)
            }
        }
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie> = COOKIE_STORE.get(url)

    /**
     * 清除所有cookie
     */
    fun clearAllCookies() {
        COOKIE_STORE.removeAll()
    }

    /**
     * 清除指定cookie
     *
     * @param url HttpUrl
     * @param cookie Cookie
     * @return if clear cookies
     */
    fun clearCookies(url: HttpUrl, cookie: Cookie): Boolean {
        return COOKIE_STORE.remove(url, cookie)
    }

    /**
     * 获取cookies
     *
     * @return List<Cookie>
    </Cookie> */
    fun getCookies(): List<Cookie> {
        return COOKIE_STORE.getCookies()
    }
}