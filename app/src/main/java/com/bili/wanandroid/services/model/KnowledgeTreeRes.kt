package com.bili.wanandroid.services.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @description:知识结构数据
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    21:11.
 **/
data class KnowledgeTreeRes(
    @SerializedName("children") val children: MutableList<Knowledge>,
    @SerializedName("courseId") val courseId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("order") val order: Int,
    @SerializedName("parentChapterId") val parentChapterId: Int,
    @SerializedName("visible") val visible: Int,
) : Serializable

data class Knowledge(
    @SerializedName("children") val children: List<Any>,
    @SerializedName("courseId") val courseId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("order") val order: Int,
    @SerializedName("parentChapterId") val parentChapterId: Int,
    @SerializedName("visible") val visible: Int
) : Serializable
