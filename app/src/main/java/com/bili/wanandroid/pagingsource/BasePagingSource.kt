package com.bili.wanandroid.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bili.wanandroid.services.BaseService

/**
 * @description:PagingSource 通用封装类
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/19    15:32.
 **/
class BasePagingSource<S : BaseService, V : Any>(
    private val pageStart: Int = BaseService.DEFAULT_PAGE_START_NO_1,
    private val service: S,
    private val load: suspend (S, Int, Int) -> List<V>
) : PagingSource<Int, V>() {

    override fun getRefreshKey(state: PagingState<Int, V>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, V> {
        val page = params.key ?: pageStart
        return try {
            val data = load(service, page, params.loadSize)
            LoadResult.Page(
                data = data,
                prevKey = if (page == pageStart) null else page - 1,
                nextKey = if (data.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}