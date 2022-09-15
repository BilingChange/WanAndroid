
package com.bili.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.bili.base.dialog.LoadingDialog
import com.bili.base.viewbinding.FragmentBinding
import com.bili.base.viewbinding.FragmentBindingDelegate

/**
 * @description:
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/12    18:48.
 **/
abstract class BaseFragment<VB : ViewBinding> : Fragment(),
  FragmentBinding<VB> by FragmentBindingDelegate() {

  /**
   * LoadingDialog
   */
  protected val loadingDialog by lazy { activity?.let { LoadingDialog(it) } }
  /**
   * 是否显示Loading布局
   */
  protected var isShowLoadingLayout = false
  /**
   * 是否显示Error布局
   */
  protected var isShowErrorLayout = false
  /**
   * 异常信息
   */
  protected lateinit var errorMsg : String
  /**
   * 是否初始化过布局
   */
  protected var isPrepared: Boolean = false
  /**
   * 是否加载过数据
   */
  protected var isDataInitiated: Boolean = false

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    isPrepared = true
    return createViewWithBinding(inflater, container)
  }

  /**
   * 通过在onResume中实现懒加载
   */
  override fun onResume() {
    super.onResume()
    if(!isDataInitiated && isPrepared){
      initData()
      initListener()
      isDataInitiated = true
    }
  }

  /**
   * 初始化数据
   */
  protected abstract fun initData()

  open fun initListener(){}

  override fun onDestroyView() {
    super.onDestroyView()
    isDataInitiated = false
    isPrepared = false
  }

  fun showDialogLoading(desc: String) {
    if (loadingDialog?.isShowing == true) {
      loadingDialog?.dismiss()
    }
    loadingDialog?.showLoading(desc)
  }

  fun showDialogLoading() {
    if (loadingDialog?.isShowing == true) {
      loadingDialog?.dismiss()
    }
    loadingDialog?.showLoading()
  }

  open fun scrollToTop(){}
}