package com.bili.base.extend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import kotlin.LazyThreadSafetyMode.*

inline fun <reified VB : ViewBinding> ViewGroup.inflate() =
  inflateBinding<VB>(LayoutInflater.from(context), this, true)

inline fun <reified VB : ViewBinding> ViewGroup.binding(attachToParent: Boolean = false) = lazy(NONE) {
  inflateBinding<VB>(LayoutInflater.from(context), if (attachToParent) this else null, attachToParent)
}
