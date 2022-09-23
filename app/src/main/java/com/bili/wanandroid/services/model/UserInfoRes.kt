package com.bili.wanandroid.services.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * @description:用户信息
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    21:18.
 **/
data class UserInfoRes(
    @SerializedName("coinCount") val coinCount: Int, // 总积分
    @SerializedName("rank") val rank: Int, // 当前排名
    @SerializedName("userId") val userId: Int,
    @SerializedName("username") val username: String
): Serializable
