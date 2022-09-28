package com.bili.wanandroid.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bili.wanandroid.services.model.HomeTabBean
import com.bili.wanandroid.ui.home.child.answer.AnswerFragment
import com.bili.wanandroid.ui.home.child.explore.ExploreFragment
import com.bili.wanandroid.ui.home.child.square.SquareFragment

/**
 * @description:首页Fragment适配器
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/26    16:22.
 **/
class HomeChildFragmentAdapter(
    var items: List<HomeTabBean>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    companion object {
        const val HOME_TAB_EXPLORE = "首页"
        const val HOME_TAB_SQUARE = "广场"
        const val HOME_TAB_ANSWER = "问答"
    }

    override fun getItemCount() = items.size

    override fun createFragment(position: Int): Fragment {
        return when (items[position].title) {
            HOME_TAB_EXPLORE -> ExploreFragment.newInstance(items[position])
            HOME_TAB_SQUARE -> SquareFragment.newInstance(items[position])
            HOME_TAB_ANSWER -> AnswerFragment.newInstance(items[position])
            else -> ExploreFragment.newInstance(items[position])
        }
    }
}