package com.bili.wanandroid.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.bili.base.vm.BaseViewModel
import com.bili.wanandroid.http.apiService
import com.bili.wanandroid.http.launchFlow
import com.bili.wanandroid.http.next
import com.bili.wanandroid.pagingsource.BasePagingSource
import com.bili.wanandroid.services.BaseService
import com.bili.wanandroid.services.model.BannerRes
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

/**
 * @description:
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/19    17:53.
 **/
class HomeViewModel : BaseViewModel() {
    /**
     * 首页banner数据
     */
    val bannerLiveData = MutableLiveData<MutableList<BannerRes>?>()

    /**
     * 获取首页列表
     */
    fun getHomeArticleList(pageSize: Int) {
        val pagingData = Pager(
            PagingConfig(
                pageSize = pageSize,
                initialLoadSize = pageSize,
                enablePlaceholders = false
            )
        ) {
            BasePagingSource(
                BaseService.DEFAULT_PAGE_START_NO,
                service = apiService
            ) { service, page, size ->
                // 根据Page来区分是否需要拉取Banner和置顶文章
//                if (page == BaseService.DEFAULT_PAGE_START_NO) {
//                    // 使用async并行请求
                    val (articlesDeferred, topsDeferred, bannersDeferred) =
                        supervisorScope {
                            Triple(
                                async { service.getArticles(page, size) },
                                async { service.getTopArticles() },
                                async { service.getBanners() })
                        }
                    val articles = articlesDeferred.await().data?.datas
                    val tops = topsDeferred.await().data
                    val banners = bannersDeferred.await().data
                    with(ArrayList<Any>(1 + tops?.size!! + articles?.size!!)) {
                        if (banners.isNullOrEmpty()) {
                            if (banners != null) {
                                addAll(banners)
                            }
                        }
                        addAll(tops)
                        addAll(articles)
                        this
                    }
//                } else {
//                    // page不为0则只是加载更多即可
//                    service.getArticles(page, size).data?.datas

//                }
            }
        }.flow
    }

//    fun getAnswerPageList()
//        val pagingData = Pager(
//            PagingConfig(
//                pageSize = BaseService.DEFAULT_PAGE_START_NO,
//                initialLoadSize = BaseService.DEFAULT_PAGE_START_NO,
//                enablePlaceholders = false
//            )
//        ) {
//            BasePagingSource(
//                BaseService.DEFAULT_PAGE_START_NO_1,
//                service = apiService
//            ) { service, page,  _ ->
//                service.getAnswerPageList(page).data?.datas
//            }
//        }.flow
//    }



    fun getBanner() {
        viewModelScope.launch {
            launchFlow(false) {
                getBanners()
            }.next {
                bannerLiveData.postValue(data)
            }
        }
    }
}