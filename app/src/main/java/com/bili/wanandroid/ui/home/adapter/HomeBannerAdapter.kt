package com.bili.wanandroid.ui.home.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bili.wanandroid.services.model.BannerRes
import com.facebook.drawee.view.SimpleDraweeView
import com.youth.banner.adapter.BannerAdapter

/**
 * @description:首页轮播图适配器
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/9/26    16:22.
 **/
class HomeBannerAdapter(items: List<BannerRes>, private val onClick: (BannerRes, Int) -> Unit) :
    BannerAdapter<BannerRes, HomeBannerAdapter.BannerViewHolder>(items) {

    class BannerViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        return BannerViewHolder(SimpleDraweeView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        })
    }

    override fun onBindView(holder: BannerViewHolder, data: BannerRes, position: Int, size: Int) {
        (holder.view as? SimpleDraweeView)?.apply {
            setImageURI(data.imagePath)
            setOnClickListener { onClick(data, position) }
        }
    }
}