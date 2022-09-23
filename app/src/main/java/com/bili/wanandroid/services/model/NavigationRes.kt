package com.bili.wanandroid.services.model

import java.io.Serializable

/**
 * @description:导航数据
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    21:13.
 **/
data class NavigationRes(
    val articles: MutableList<ArticleDetailRes>,
    val cid: Int,
    val name: String
): Serializable
