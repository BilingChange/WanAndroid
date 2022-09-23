package com.bili.wanandroid.services.model

import java.io.Serializable

/**
 * @description:热搜词
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    21:09.
 **/
data class HotKeyRes(
    val id: Int,
    val link: String,
    val name: String,
    val order: Int,
    val visible: Int
): Serializable