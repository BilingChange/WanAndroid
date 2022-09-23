package com.bili.wanandroid.services

import com.bili.wanandroid.http.BaseResponse
import com.bili.wanandroid.services.model.*
import retrofit2.http.*

/**
 * @description:
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/15    20:16.
 **/
interface ApiService : BaseService {

    /**
     * 首页banner轮播图
     */
    @GET("banner/json")
    suspend fun getBanners(): BaseResponse<MutableList<BannerRes>>

    /**
     * 首页文章列表
     */
    @GET("article/list/{pageNo}/json")
    suspend fun getArticles(
        @Path("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): BaseResponse<ArticleListRes>

    /**
     * 首页置顶文章
     */
    @GET("article/top/json")
    suspend fun getTopArticles(): BaseResponse<MutableList<ArticleDetailRes>>

    /**
     * 获取广场文章列表
     */
    @GET("user_article/list/{page}/json")
    suspend fun getSquareList(@Path("page") page: Int): BaseResponse<ArticleListRes>

    /**
     * 问答列表
     */
    @GET("wenda/list/{pageNo}/json")
    suspend fun getAnswerPageList(@Path("pageNo") pageNo: Int): BaseResponse<PageRes<ArticleDetailRes>>

    /**
     * 获取公众号列表
     */
    @GET("/wxarticle/chapters/json")
    suspend fun getWXChapters(): BaseResponse<MutableList<WxChapterRes>>

    /**
     * 公众号对应列表
     */
    @GET("/wxarticle/list/{id}/{page}/json")
    suspend fun getWxArticles(
        @Path("id") id: Int,
        @Path("page") page: Int
    ): BaseResponse<ArticleListRes>

    /**
     * 知识体系列表
     */
    @GET("tree/json")
    suspend fun getKnowledgeTree(): BaseResponse<MutableList<KnowledgeTreeRes>>

    /**
     * 导航数据
     */
    @GET("navi/json")
    suspend fun getNavigationList(): BaseResponse<MutableList<NavigationRes>>

    /**
     * 项目列表tab
     */
    @GET("project/tree/json")
    suspend fun getProjectTree(): BaseResponse<MutableList<ProjectTreeRes>>

    /**
     * 项目列表数据
     */
    @GET("project/list/{page}/json")
    suspend fun getProjectList(
        @Path("page") page: Int,
        @Query("cid") cid: Int
    ): BaseResponse<ArticleListRes>

    /**
     * 最新项目列表
     */
    @GET("article/listproject/{pageNo}/json")
    suspend fun getNewProjectPageList(
        @Path("pageNo") pageNo: Int,
        @Query("page_size") pageSize: Int
    ): BaseResponse<ArticleListRes>

    /**
     * 登录
     */
    @POST("user/login")
    @FormUrlEncoded
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String,
    ): BaseResponse<LoginInfo>

    /**
     * 获取个人信息
     */
    @GET("/lg/coin/userinfo/json")
    suspend fun getUserInfo(): BaseResponse<UserInfoRes>

    /**
     * 退出登录
     */
    @GET("user/logout/json")
    suspend fun logout(): BaseResponse<Any>


    /**
     * 收藏列表
     */
    @GET("lg/collect/list/{page}/json")
    suspend fun getCollectList(@Path("page") page: Int): BaseResponse<PageRes<CollectRes>>

    /**
     * 文章收藏
     */
    @POST("lg/collect/{id}/json")
    suspend fun addCollectArticle(@Path("id") id: Int): BaseResponse<Any>

    /**
     * 文章取消收藏
     */
    @POST("lg/uncollect_originId/{id}/json")
    suspend fun cancelCollectArticle(@Path("id") id: Int): BaseResponse<Any>
}