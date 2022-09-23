package com.bili.wanandroid.services.model

import java.io.Serializable

/**
 * @description:收藏
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    21:09.
 **/
data class CollectRes(
    val author: String = "",
    val chapterId: Int = 0,
    val chapterName: String = "",
    val courseId: Int = 0,
    val desc: String = "",
    val envelopePic: String = "",
    val id: Int = 0,
    val link: String = "",
    val niceDate: String = "",
    val origin: String = "",
    val originId: Int = 0,
    val publishTime: Long = 0,
    val title: String = "",
    val userId: Int = 0,
    val visible: Int = 0,
    val zan: Int = 0,
): Serializable {
    /**
     * 是否收藏状态
     */
    var collect: Boolean = true
}