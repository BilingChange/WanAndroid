package com.bili.base.event

/**
 * @description:
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/12    10:48.
 **/
data class LoadingErrorEvent(
    var loadingErrorMsg : String,
    var loadingErrorState: Boolean
)
