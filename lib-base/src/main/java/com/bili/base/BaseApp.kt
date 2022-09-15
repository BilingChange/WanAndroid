package com.bili.base

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

/**
 * @description:
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/12    18:48.
 **/
open abstract class BaseApp : Application() {

    companion object{
       var context: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}