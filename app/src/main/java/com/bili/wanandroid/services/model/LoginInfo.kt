package com.bili.wanandroid.services.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @description:登录数据
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    21:13.
 **/
data class LoginInfo(
    @SerializedName("chapterTops") val chapterTops: MutableList<String>,
    @SerializedName("collectIds") val collectIds: MutableList<String>,
    @SerializedName("email") val email: String,
    @SerializedName("icon") val icon: String,
    @SerializedName("id") val id: Int,
    @SerializedName("password") val password: String,
    @SerializedName("token") val token: String,
    @SerializedName("type") val type: Int,
    @SerializedName("username") val username: String
): Serializable
