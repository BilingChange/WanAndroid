package com.bili.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.bili.base.dialog.LoadingDialog
import com.bili.base.viewbinding.ActivityBinding
import com.bili.base.viewbinding.ActivityBindingDelegate

/**
 * @description:
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/12    18:48.
 **/
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity(),
  ActivityBinding<VB> by ActivityBindingDelegate() {

  protected val loadingDialog by lazy { LoadingDialog(this) }

  protected var isShowLoadingLayout = false
  protected var isShowErrorLayout = false
  protected lateinit var errorMsg: String

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentViewWithBinding()
  }

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

}