package com.bili.wanandroid.ui.home.child.explore

import androidx.core.os.bundleOf
import com.bili.base.BaseVmFragment
import com.bili.wanandroid.databinding.FragmentHomeChildExploreBinding
import com.bili.wanandroid.services.model.HomeTabBean
import com.bili.wanandroid.ui.home.HomeFragment

/**
 * @description:
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/25    11:29 下午.
 **/
class ExploreFragment : BaseVmFragment<FragmentHomeChildExploreBinding,ExploreViewModel>() {

    companion object {
        private const val KEY_HOME_FRAGMENT_LIST_SAVE_STATE = "key_home_fragment_list_save_state"

        fun newInstance(homeTabBean: HomeTabBean): ExploreFragment = with(ExploreFragment()) {
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