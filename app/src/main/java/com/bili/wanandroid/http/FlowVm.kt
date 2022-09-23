package com.bili.wanandroid.http

import android.text.TextUtils
import com.bili.base.event.DialogLoadingEvent
import com.bili.base.vm.BaseViewModel
import com.bili.wanandroid.http.exception.ApiException
import com.bili.wanandroid.http.exception.ExceptionHandle
import com.bili.wanandroid.services.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import java.util.concurrent.CancellationException

/**
 * @description:ViewModel扩展方法实现Flow请求模板
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    20:29.
 **/
suspend fun <T> BaseViewModel.launchFlow(
    showLoading: Boolean = true,
    isToastError: Boolean = true,
    request: suspend ApiService.() -> BaseResponse<T>
): Flow<BaseResponse<T>> {
    if (showLoading) {
        showLayoutLoading()
    }
    return flow {
        val response = request.invoke(apiService)
        if (!response.isSuccess) {
            throw ApiException(response.errorMsg ?: "", response.errorCode!!)
        }
        emit(response)
    }.flowOn(Dispatchers.IO)
        .onCompletion { throwable ->
            if (showLoading) {
                hideLayoutLoading()
            }
            throwable?.let { throw catchException(this@launchFlow, throwable, isToastError) }
        }
}

suspend fun <T> BaseViewModel.postFlow(
    showDialogLoading: Boolean = true,
    isToastError: Boolean = true,
    loadingStr: String = "加载中...",
    request: suspend ApiService.() -> BaseResponse<T>
): Flow<BaseResponse<T>> {
    if (showDialogLoading) {
        showLoading(DialogLoadingEvent(loadingStr, true))
    }
    return flow {
        val response = request.invoke(apiService)
        if (!response.isSuccess) {
            throw ApiException(response.errorMsg ?: "", response.errorCode!!)
        }
        emit(response)
    }.flowOn(Dispatchers.IO)
        .onCompletion { throwable ->
            if (showDialogLoading) {
                closeLoading(DialogLoadingEvent("", false))
            }
            throwable?.let { throw catchException(this@postFlow, throwable, isToastError) }
        }
}

fun catchException(
    vm: BaseViewModel,
    e: Throwable, isToastError: Boolean
): Throwable {
    e.printStackTrace()
    if (e is CancellationException) {
        return e
    }
    val errorMsg = ExceptionHandle.handleException(e)
    if (isToastError && !TextUtils.isEmpty(errorMsg)) {
        vm.requestErrorEvent.postValue(errorMsg)
    }
    return e
}

/**
 * 简化在示例中catch的处理
 */
suspend fun <T> Flow<T>.next(block: suspend T.() -> Unit): Unit = catch { }.collect {
    block(it)
}

fun <T> Flow<T>.onError(block: Throwable.() -> Unit) = catch { cause ->
    block(cause)
}
