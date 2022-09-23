package com.bili.wanandroid

import com.alibaba.android.arouter.launcher.ARouter
import com.bili.base.BaseApp

/**
 * @description:应用Application
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    16:56.
 **/
class WanApp : BaseApp() {

    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG){
            ARouter.openLog()
            ARouter.openDebug()
        }
        //初始化ARouter
        ARouter.init(this)
    }
}