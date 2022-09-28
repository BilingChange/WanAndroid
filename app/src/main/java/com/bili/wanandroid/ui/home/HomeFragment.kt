package com.bili.wanandroid.ui.home

import android.content.Intent
import com.bili.base.BaseVmFragment
import com.bili.wanandroid.databinding.FragmentHomeBinding
import com.bili.wanandroid.services.model.HomeTabBean
import com.bili.wanandroid.ui.home.adapter.HomeChildFragmentAdapter
import com.bili.wanandroid.ui.search.SearchActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

/**
 * @description:
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/19    15:32.
 **/
class HomeFragment : BaseVmFragment<FragmentHomeBinding, HomeViewModel>() {

    companion object {
        const val KEY_HOME_TAB_CHILD_PARCELABLE = "key_child_tab_parcelable"
    }

    private lateinit var mChildAdapter:HomeChildFragmentAdapter

    override fun initData() {
        mChildAdapter = HomeChildFragmentAdapter(generateHomeTabs(),this.childFragmentManager,lifecycle)
        binding.homeViewpager2.adapter = mChildAdapter
        binding.ivSearch.setOnClickListener {
            startActivity(Intent(this.context,SearchActivity::class.java))
        }

        TabLayoutMediator(binding.homeTabLayout,binding.homeViewpager2){ tab: TabLayout.Tab, position: Int ->
            tab.text = mChildAdapter.items[position].title
        }.apply(TabLayoutMediator::attach)
        with(binding.swipeRefreshLayout) {
            setOnRefreshListener {
                //this@HomeFragment.viewModel.refreshEvent(mChildAdapter.items[binding .homeViewpager2.currentItem])
                //this.isRefreshing = false
            }
        }
    }

    private fun generateHomeTabs() = listOf(
        HomeTabBean(HomeChildFragmentAdapter.HOME_TAB_EXPLORE),
        HomeTabBean(HomeChildFragmentAdapter.HOME_TAB_SQUARE),
        HomeTabBean(HomeChildFragmentAdapter.HOME_TAB_ANSWER),
    )

    override fun scrollToTop() {
        super.scrollToTop()
    }
}