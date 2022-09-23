package com.bili.wanandroid.constant

import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatDelegate
import com.bili.base.BaseApp

/**
 * 设置页常量
 */
object Constants {
    private const val KEY_NORMAL_CATEGORY_DYNAMIC_COLORS = "normal_dynamic_colors"
    private const val KEY_NORMAL_CATEGORY_DARK_MODE = "normal_dark_mode"
    private const val DARK_MODE_ON = "on"
    private const val DARK_MODE_OFF = "off"
    private const val DARK_MODE_FOLLOW_SYSTEM = "system"

    const val KEY_OTHER_CATEGORY_ABOUT = "other_about"
    const val KEY_OTHER_CATEGORY_GITHUB = "other_github"
    const val KEY_OTHER_CATEGORY_LOGOUT = "other_logout"

    /**
     * 是否开启深色模式
     */
    @AppCompatDelegate.NightMode
    val preferenceDarkMode: Int
        get() {
            return getNightMode(
                PreferenceManager.getDefaultSharedPreferences(BaseApp.context)
                    .getString(KEY_NORMAL_CATEGORY_DARK_MODE, DARK_MODE_FOLLOW_SYSTEM)
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
