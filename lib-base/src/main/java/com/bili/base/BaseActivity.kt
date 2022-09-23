package com.bili.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.bili.base.dialog.LoadingDialog
import com.bili.base.viewbinding.ActivityBinding
import com.bili.base.viewbinding.ActivityBindingDelegate
import com.gyf.immersionbar.ImmersionBar

/**
 * @description:
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/12    18:48.
 **/
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity(),
  ActivityBinding<VB> by ActivityBindingDelegate() {

  /**
   * 加载LoadingDialog对话框
   */
  protected val loadingDialog by lazy { LoadingDialog(this) }

  /**
   * 是否显示加载布局
   */
  protected var isShowLoadingLayout = false

  /**
   * 是否显示异常布局
   */
  protected var isShowErrorLayout = false

  /**
   * 异常信息
   */
  protected lateinit var errorMsg: String

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentViewWithBinding()
    initImmersionBar()
    initData()
    initListener()
  }

  protected abstract fun initData()

  open fun initListener() {}

  fun showDialogLoading(desc: String) {
    if (loadingDialog.isShowing) {
      loadingDialog.dismiss()
    }
    loadingDialog.showLoading(desc)
  }

  fun showDialogLoading() {
    if (loadingDialog.isShowing) {
      loadingDialog.dismiss()
    }
    loadingDialog.showLoading()
  }

  /**
   * 沉浸式状态栏
   */
  fun initImmersionBar(){
    ImmersionBar.with(this)
      .statusBarDarkFont(true)
      .navigationBarColor(R.color.white)
      .navigationBarDarkIcon(true)
      .init()
  }
}