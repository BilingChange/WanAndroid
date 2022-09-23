package com.bili.wanandroid.services.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @description:标签
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    21:09.
 **/
data class Tag(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
): Serializable
