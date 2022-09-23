package com.bili.wanandroid

import com.bili.base.BaseVmActivity
import com.bili.wanandroid.databinding.ActivityMainBinding
import com.bili.wanandroid.ui.home.HomeFragment
import com.bili.wanandroid.ui.navigator.NavigatorFragment

/**
 * @description:
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    20:16.
 **/
class MainActivity : BaseVmActivity<ActivityMainBinding,MainViewModel>() {


    private var fragmentList = listOf(
            HomeFragment(),
//            ProjectFragment(),
            NavigatorFragment(),
//            GroupFragment()
        )

    override fun initData() {
    }

    override fun initListener() {
        super.initListener()
    }

}