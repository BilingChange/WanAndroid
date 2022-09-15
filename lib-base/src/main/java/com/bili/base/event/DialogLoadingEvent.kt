package com.bili.base.event

/**
 * @description:
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/12    18:48.
 **/
data class DialogLoadingEvent(
    var loadingMsg : String,
    var loadingState : Boolean = false
)
