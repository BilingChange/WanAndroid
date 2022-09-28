package com.bili.wanandroid

import android.os.Bundle
import android.view.MenuItem
import com.bili.base.BaseVmActivity
import com.bili.wanandroid.constant.Constants
import com.bili.wanandroid.databinding.ActivityMainBinding
import com.bili.wanandroid.ui.group.GroupFragment
import com.bili.wanandroid.ui.home.HomeFragment
import com.bili.wanandroid.ui.navigator.NavigatorFragment
import com.bili.wanandroid.ui.project.ProjectFragment

/**
 * @description:
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    20:16.
 **/
class MainActivity : BaseVmActivity<ActivityMainBinding,MainViewModel>() {


    /**
     * 当前Fragment索引
     */
    private var currentFragmentIndex = -1
    /**
     * 首页fragment集合
     */
    private var fragmentList = listOf(HomeFragment(), ProjectFragment(),
            NavigatorFragment(), GroupFragment()
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            switchFragment(Constants.ZERO_INT)
        }
    }

    override fun initData() {

    }

    override fun initListener() {
        super.initListener()
        binding.navView.setOnItemSelectedListener {
            onBottomItemSelect(it)
        }

        binding.floatingAction.setOnClickListener{
            fragmentList[currentFragmentIndex].scrollToTop()
        }
    }

    private fun onBottomItemSelect(item: MenuItem): Boolean {
        switchFragment(getFragmentIndex(item.itemId))
        return true
    }

    private fun switchFragment(fragmentIndex: Int) {
        if (fragmentIndex != currentFragmentIndex) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            val fragment = fragmentList[fragmentIndex]
            fragmentList.getOrNull(currentFragmentIndex)?.apply(fragmentTransaction::hide)
            if (!fragment.isAdded) {
                fragmentTransaction.add(
                    R.id.nav_host_fragment,
                    fragment,
                    fragment.javaClass.simpleName
                ).show(fragment)
            } else {
                fragmentTransaction.show(fragment)
            }
            fragmentTransaction.commitAllowingStateLoss()
            currentFragmentIndex = fragmentIndex
        }
    }

    private fun getTagFromItemId(itemId: Int) = fragmentList[getFragmentIndex(itemId)].tag
        ?: HomeFragment::class.java.simpleName

    private fun getFragmentIndex(itemId: Int): Int {
        return when (itemId) {
            R.id.nav_home -> Constants.ZERO_INT
            R.id.nav_project -> Constants.ONE_INT
            R.id.nav_navigator -> Constants.TWO_INT
            R.id.nav_wechat -> Constants.THREE_INT
            else -> Constants.ZERO_INT
        }
    }

}