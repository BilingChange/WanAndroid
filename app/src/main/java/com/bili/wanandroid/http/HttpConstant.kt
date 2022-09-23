package com.bili.wanandroid.http

import com.bili.base.utils.SharePreferenceUtils

/**
 * @description:Http常量配置
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    21:09.
 **/
object HttpConstant {
    /**
     * 默认超时时间
     */
    const val DEFAULT_TIMEOUT: Long = 15

    /**
     * BASE_URL
     */
    const val BASE_URL = "https://www.wanandroid.com"

    const val COLLECTIONS_WEBSITE = "lg/collect"
    const val UNCOLLECTIONS_WEBSITE = "lg/uncollect"
    const val ARTICLE_WEBSITE = "article"
    const val TODO_WEBSITE = "lg/todo"
    const val COIN_WEBSITE = "lg/coin"
    const val TOKEN_KEY = "token"
    const val COOKIE_NAME = "Cookie"
    const val SET_COOKIE_KEY = "set-cookie"
    const val SAVE_USER_LOGIN_KEY = "user/login"
    const val SAVE_USER_REGISTER_KEY = "user/register"


    fun encodeCookie(cookies: List<String>): String {
        val sb = StringBuilder()
        val set = HashSet<String>()
        cookies.map { cookie ->
            cookie.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        }.forEach {
            it.filterNot { set.contains(it) }.forEach { set.add(it) }
        }
        val ite = set.iterator()
        while (ite.hasNext()) {
            val cookie = ite.next()
            sb.append(cookie).append(";")
        }
        val last = sb.lastIndexOf(";")
        if (sb.length - 1 == last) {
            sb.deleteCharAt(last)
        }
        return sb.toString()
    }

    fun saveCookie(url: String?, domain: String?, cookies: String) {
        url ?: return
        var spUrl: String by SharePreferenceUtils(url, cookies)
        @Suppress("UNUSED_VALUE")
        spUrl = cookies
        domain ?: return
        var spDomain: String by SharePreferenceUtils(domain, cookies)
        @Suppress("UNUSED_VALUE")
        spDomain = cookies
    }
}