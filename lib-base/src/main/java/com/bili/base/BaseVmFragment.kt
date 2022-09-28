
package com.bili.base

import android.text.TextUtils
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.bili.base.utils.ToastUtils
import com.bili.base.utils.saveAs
import com.bili.base.vm.BaseViewModel
import java.lang.reflect.ParameterizedType

/**
 * @description:
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/12    18:48.
 **/
abstract class BaseVmFragment<VB : ViewBinding,VM : BaseViewModel> : BaseFragment<VB>() {

  /**
   * viewModel
   */
  protected val viewModel: VM by lazy {
    val type = javaClass.genericSuperclass
    val modelClass: Class<VM> = type!!.saveAs<ParameterizedType>().actualTypeArguments[1].saveAs()
    ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(modelClass)
  }

  override fun onResume() {
    if(!isDataInitiated && isPrepared){
      initViewModel()
      lifecycle.addObserver(viewModel)
      initObserver()
    }
    super.onResume()
  }

  private fun initViewModel() {
    viewModel.application = requireActivity().application.saveAs()
  }

  fun getVm(): VM {
    return viewModel
  }

  override fun onDestroyView() {
    super.onDestroyView()
    lifecycle.removeObserver(viewModel)
  }

  protected fun initObserver() {
    viewModel.dialogLoadingEvent.observe(viewLifecycleOwner) {
      if (it.loadingState) {
        if (TextUtils.isEmpty(it.loadingMsg)) showDialogLoading() else showDialogLoading(it
        .loadingMsg)
      }else{
        loadingDialog?.dismiss()
      }
    }

    viewModel.layoutLoadingEvent.observe(viewLifecycleOwner){
      val rlLoading = binding?.root?.findViewById<RelativeLayout>(R.id.rl_loading)
      rlLoading?.visibility = if(it) View.VISIBLE else View.GONE
    }

    viewModel.loadErrorEvent.observe(viewLifecycleOwner){
      isShowErrorLayout = it.loadingErrorState
      errorMsg = it.loadingErrorMsg
      val llError = binding?.root?.findViewById<LinearLayout>(R.id.ll_error)
      val tvError = binding?.root?.findViewById<TextView>(R.id.tv_error)
      llError?.visibility = if(it.loadingErrorState) View.VISIBLE else View.GONE
      tvError?.text = it.loadingErrorMsg
    }

    viewModel.requestErrorEvent.observe(viewLifecycleOwner){
      ToastUtils.show(it)
    }
  }
}