package com.bili.wanandroid.utils

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.text.TextUtils
import com.bili.base.BaseApp.Companion.context
import com.bili.wanandroid.BuildConfig
import java.io.Closeable
import java.io.IOException

/**
 * @description:应用环境工具类
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    20:10.
 **/
object SystemUtil {

    private var channel: String? = ""

    fun getChannelName(): String? {
        return if (!TextUtils.isEmpty(channel)) {
            channel
        } else {
            try {
                val appInfo: ApplicationInfo = context.packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
                channel = appInfo.metaData.getString("MULTI_CHANNEL")
                if (TextUtils.isEmpty(channel)) {
                    channel = "google"
                }
            } catch (var1: PackageManager.NameNotFoundException) {
                var1.printStackTrace()
            }
            channel
        }
    }

    /**
     * 正式发布的环境包
     */
    fun isPublishRelease(): Boolean{
        return !BuildConfig.DEBUG && BuildConfig.IS_ONLINE_ENV
    }

    /**
     * 测试环境
     */
    fun isBeta(): Boolean {
        return !BuildConfig.IS_ONLINE_ENV
    }

    fun closeQuietly(closeable: Closeable?) {
        try {
            closeable?.close()
        } catch (var2: IOException) {
            var2.printStackTrace()
        }
    }
}