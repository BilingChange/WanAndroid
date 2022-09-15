package com.bili.base.viewbinding

import android.app.Activity
import android.view.View
import androidx.viewbinding.ViewBinding

interface ActivityBinding<VB : ViewBinding> {
  val binding: VB
  fun Activity.setContentViewWithBinding(): View
}

class ActivityBindingDelegate<VB : ViewBinding> : ActivityBinding<VB> {
  private lateinit var _binding: VB

  override val binding: VB get() = _binding

  override fun Activity.setContentViewWithBinding(): View {
    _binding = ViewBindingUtil.inflateWithGeneric(this, layoutInflater)
    setContentView(_binding.root)
    return _binding.root
  }
}