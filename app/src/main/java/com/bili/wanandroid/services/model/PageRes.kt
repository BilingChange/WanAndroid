package com.bili.wanandroid.services.model

import java.io.Serializable

data class PageRes<T>(
    val curPage: Int,
    val datas: List<T>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
): Serializable