package com.bili.wanandroid.http

import java.io.Serializable

/**
 * @description:Base实体类
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    20:29.
 **/
class BaseResponse<T>(
    val data: T? = null,
    val errorCode: Int? = null,
    val errorMsg: String? = null,
    val error: Throwable? = null
) : Serializable {
    val isSuccess: Boolean
        get() = errorCode == 0
}