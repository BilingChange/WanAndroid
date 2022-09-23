package com.bili.wanandroid.services.model

import com.google.gson.annotations.SerializedName

/**
 * @description:文章列表实体
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    21:09.
 **/
data class ArticleListRes(
    @SerializedName("curPage") val curPage: Int,
    @SerializedName("datas") var datas: MutableList<ArticleDetailRes>,
    @SerializedName("offset") val offset: Int,
    @SerializedName("over") val over: Boolean,
    @SerializedName("pageCount") val pageCount: Int,
    @SerializedName("size") val size: Int,
    @SerializedName("total") val total: Int
)
