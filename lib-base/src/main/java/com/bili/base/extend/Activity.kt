package com.bili.base.extend

import androidx.activity.ComponentActivity
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import kotlin.LazyThreadSafetyMode.*

inline fun <reified VB : ViewBinding> ComponentActivity.binding(setContentView: Boolean = true) = lazy(NONE) {
  inflateBinding<VB>(layoutInflater).also { binding ->
    if (setContentView) setContentView(binding.root)
    if (binding is ViewDataBinding) binding.lifecycleOwner = this
  }
}
