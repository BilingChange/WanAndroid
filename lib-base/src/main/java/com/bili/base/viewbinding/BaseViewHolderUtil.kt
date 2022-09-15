package com.bili.base.viewbinding

import android.view.View
import androidx.viewbinding.ViewBinding
import com.bili.base.R
import com.chad.library.adapter.base.viewholder.BaseViewHolder

@Suppress("UNCHECKED_CAST")
fun <VB : ViewBinding> BaseViewHolder.getBinding(bind: (View) -> VB): VB =
  itemView.getTag(R.id.tag_view_binding) as? VB ?: bind(itemView).also { itemView.setTag(R.id.tag_view_binding, it) }
