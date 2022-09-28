package com.bili.wanandroid.utils

import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatDelegate
import com.bili.base.BaseApp

/**
 * @description:
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/27    9:54.
 **/
object NightModeUtil {

    private val KEY_NORMAL_CATEGORY_DYNAMIC_COLORS = "normal_dynamic_colors"
    private val KEY_NORMAL_CATEGORY_DARK_MODE = "normal_dark_mode"

    /**
     * 夜间模式开
     */
    private val DARK_MODE_ON = "on"

    /**
     * 夜间模式关
     */
    private val DARK_MODE_OFF = "off"

    /**
     * 跟随系统
     */
    private val DARK_MODE_FOLLOW_SYSTEM = "system"

    /**
     * 是否开启深色模式
     */
    @AppCompatDelegate.NightMode
    val preferenceDarkMode: Int
        get() {
            return getNightMode(
                PreferenceManager.getDefaultSharedPreferences(BaseApp.context)
                    .getString(
                        KEY_NORMAL_CATEGORY_DARK_MODE,
                        DARK_MODE_FOLLOW_SYSTEM
                    )
                    ?: DARK_MODE_FOLLOW_SYSTEM
            )
        }

    /**
     * 夜间模式
     */
    fun getNightMode(value: String) =
        when (value) {
            DARK_MODE_ON -> AppCompatDelegate.MODE_NIGHT_YES
            DARK_MODE_OFF -> AppCompatDelegate.MODE_NIGHT_NO
            else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        }

    /**
     * 是否开启动态主题色
     */
    val preferenceDynamicColors: Boolean
        get() {
            return PreferenceManager.getDefaultSharedPreferences(BaseApp.context)
                .getBoolean(KEY_NORMAL_CATEGORY_DYNAMIC_COLORS, true)
        }

}