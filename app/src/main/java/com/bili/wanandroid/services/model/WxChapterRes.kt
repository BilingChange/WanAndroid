package com.bili.wanandroid.services.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * @description:公众号体系tab数据实体
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    20:18.
 **/
data class WxChapterRes(
    @SerializedName("children") val children: MutableList<String>,
    @SerializedName("courseId") val courseId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("order") val order: Int,
    @SerializedName("parentChapterId") val parentChapterId: Int,
    @SerializedName("userControlSetTop") val userControlSetTop: Boolean,
    @SerializedName("visible") val visible: Int
): Serializable
