package com.bili.wanandroid.services.model

import com.google.gson.annotations.SerializedName


/**
 * @description:首页轮播图片
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    21:09.
 **/
data class BannerRes(
    @SerializedName("desc") val desc: String,
    @SerializedName("id") val id: Int,
    @SerializedName("imagePath") val imagePath: String,
    @SerializedName("isVisible") val isVisible: Int,
    @SerializedName("order") val order: Int,
    @SerializedName("title") val title: String,
    @SerializedName("type") val type: Int,
    @SerializedName("url") val url: String
)