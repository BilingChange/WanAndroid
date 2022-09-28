package com.bili.wanandroid.ui.home.child.square

import androidx.core.os.bundleOf
import com.bili.base.BaseVmFragment
import com.bili.wanandroid.databinding.FragmentHomeChildSquareBinding
import com.bili.wanandroid.services.model.HomeTabBean
import com.bili.wanandroid.ui.home.HomeFragment

/**
 * @description:
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/25    11:30 下午.
 **/
class SquareFragment:BaseVmFragment<FragmentHomeChildSquareBinding,SquareViewModel>() {

    companion object {
        fun newInstance(homeTabBean: HomeTabBean) = with(SquareFragment()) {
            arguments = bundleOf(
                HomeFragment.KEY_HOME_TAB_CHILD_PARCELABLE to homeTabBean
            )
            this
        }
    }

    override fun initData() {
        this.viewModel.hideLayoutLoading()
    }
}