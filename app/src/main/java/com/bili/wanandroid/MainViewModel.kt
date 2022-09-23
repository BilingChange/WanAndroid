package com.bili.wanandroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bili.base.utils.SharePreferenceUtils
import com.bili.base.vm.BaseViewModel
import com.bili.wanandroid.http.launchFlow
import com.bili.wanandroid.http.next
import com.bili.wanandroid.http.postFlow
import com.bili.wanandroid.services.model.UserInfoRes
import kotlinx.coroutines.launch

/**
 * @description:
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/16    19:56.
 **/
class MainViewModel : BaseViewModel() {

    /**
     * 用户信息
     */
    private val userInfoLiveData = MutableLiveData<UserInfoRes?>()

    /**
     * 退出登录
     */
    private val logoutLiveData = MutableLiveData<Any?>()

    fun getUserInfo(){
        viewModelScope.launch {
            launchFlow(showLoading = false, isToastError = false) {
                getUserInfo()
            }.next {
                userInfoLiveData.postValue(data)
            }
        }
    }

    /**
     * 退出登录
     */
    fun logout(loadingStr: String){
        viewModelScope.launch {
            postFlow(loadingStr = loadingStr){
                logout()
            }.next {
                SharePreferenceUtils.clearPreference()
                logoutLiveData.postValue(data)
            }
        }
    }
}