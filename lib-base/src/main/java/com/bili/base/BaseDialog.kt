package com.bili.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.bili.base.viewbinding.ViewBindingUtil

abstract class BaseDialog<VB : ViewBinding>(context: Context, themeResId: Int = 0)
  : Dialog(context, themeResId) {

  lateinit var binding: VB

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ViewBindingUtil.inflateWithGeneric(this, layoutInflater)
    setContentView(binding.root)
  }
}