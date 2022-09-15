package com.bili.base.vm

import androidx.lifecycle.ViewModel
import com.bili.base.BaseApp
import com.bili.base.event.DialogLoadingEvent
import com.bili.base.event.LoadingErrorEvent
import com.kunminx.architecture.ui.callback.UnPeekLiveData

/**
 * @description:
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/12    13:48.
 **/
abstract class BaseViewModel : ViewModel(), ViewModelLifecycle, IView {

    /**
     * application上下文
     */
    lateinit var application: BaseApp

    val dialogLoadingEvent = UnPeekLiveData<DialogLoadingEvent>()
    val layoutLoadingEvent = UnPeekLiveData<Boolean>()
    val loadErrorEvent = UnPeekLiveData<LoadingErrorEvent>()
    val requestErrorEvent = UnPeekLiveData<String>()

    override fun showLoading(loadingEnevt: DialogLoadingEvent) {
        dialogLoadingEvent.postValue(loadingEnevt)
    }

    override fun closeLoading(loadingEnevt: DialogLoadingEvent) {
        dialogLoadingEvent.postValue(loadingEnevt)
    }

    override fun showLayoutLoading() {
        layoutLoadingEvent.postValue(true)
    }

    override fun hideLayoutLoading() {
        layoutLoadingEvent.postValue(false)
    }

    override fun showLoadError(loadingErrorEvent: LoadingErrorEvent) {
        loadErrorEvent.postValue(loadingErrorEvent)
    }

}

