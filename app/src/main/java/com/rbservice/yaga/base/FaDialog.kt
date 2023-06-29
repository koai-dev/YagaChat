package com.rbservice.yaga.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import com.rbservice.yaga.R

abstract class FaDialog : DialogFragment() {
    private var binding: ViewBinding? = null
    var baseAction: BaseAction? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getBindingView(container)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireDialog().setCanceledOnTouchOutside(true)
        requireDialog().window?.attributes?.windowAnimations = R.style.DialogAnimation
        requireDialog().window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        if (binding != null) {
            initView(savedInstanceState, binding!!)
            baseAction?.getData()
            baseAction?.onClick()
            baseAction?.onObserver()
        }
    }

    abstract fun getBindingView(container: ViewGroup?): ViewBinding?

    abstract fun initView(savedInstanceState: Bundle?, binding: ViewBinding)

    interface Callback<T>{
        fun onDismiss(t: T)
    }
}