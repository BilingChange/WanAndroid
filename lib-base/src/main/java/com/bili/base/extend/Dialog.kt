package com.bili.base.extend

import android.app.Dialog
import androidx.viewbinding.ViewBinding
import kotlin.LazyThreadSafetyMode.NONE

inline fun <reified VB : ViewBinding> Dialog.binding() = lazy(NONE) {
  inflateBinding<VB>(layoutInflater).also { setContentView(it.root) }
}
