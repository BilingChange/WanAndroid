package com.bili.base.vm

import com.bili.base.event.DialogLoadingEvent
import com.bili.base.event.LoadingErrorEvent

/**
 * @description:
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/12    13:48.
 **/
interface IView {

    /**
     * 展示DialogLoading,如用在登录接口提交时
     */
    fun showLoading(loadingEvent: DialogLoadingEvent)

    /**
     * 关闭DialogLoading
     */
    fun closeLoading(loadingEvent: DialogLoadingEvent)

    /**
     * 页面加载数据时的loading提示
     */
    fun showLayoutLoading()

    /**
     * 隐藏布局加载
     */
    fun hideLayoutLoading()

    /***
     * 数据加载失败 或者无数据处理
     */
    fun showLoadError(loadingErrorEvent: LoadingErrorEvent)
}