package com.bili.base

import android.os.Bundle
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
abstract class BaseVmActivity<VB : ViewBinding, VM : BaseViewModel> : BaseActivity<VB>() {

    protected val viewModel: VM by lazy {
        val type = javaClass.genericSuperclass
        val vmClass: Class<VM> = type!!.saveAs<ParameterizedType>().actualTypeArguments[1].saveAs()
        ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(vmClass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithBinding()
        initViewModel()
        initObserver()
    }


    private fun initViewModel() {
        viewModel.application = application.saveAs()
        lifecycle.addObserver(viewModel)
    }

    fun getVm(): VM {
        return viewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(viewModel)
    }

    protected fun initObserver() {
        viewModel.dialogLoadingEvent.observe(this) {
            if (it.loadingState) {
                if (TextUtils.isEmpty(it.loadingMsg)) showDialogLoading() else showDialogLoading(
                    it.loadingMsg
                )
            } else {
                loadingDialog.dismiss()
            }
        }

        viewModel.layoutLoadingEvent.observe(this) {
            val rlLoading = binding.root.findViewById<RelativeLayout>(R.id.rl_loading)
            rlLoading?.visibility = if (it) View.VISIBLE else View.GONE
        }

        viewModel.loadErrorEvent.observe(this) {
            isShowErrorLayout = it.loadingErrorState
            errorMsg = it.loadingErrorMsg
            val llError = binding?.root?.findViewById<LinearLayout>(R.id.ll_error)
            val tvError = binding?.root?.findViewById<TextView>(R.id.tv_error)
            llError?.visibility = if (it.loadingErrorState) View.VISIBLE else View.GONE
            tvError?.text = it.loadingErrorMsg
        }

        viewModel.requestErrorEvent.observe(this) {
            ToastUtils.show(it)
        }
    }
}