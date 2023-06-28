package com.rbservice.yaga.ui.call

import android.os.Bundle
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.rbservice.yaga.base.FaFragment
import com.rbservice.yaga.databinding.FragmentCallBinding

class CallFragment : FaFragment() {
    private lateinit var binding: FragmentCallBinding
    override fun getBindingView(container: ViewGroup?): ViewBinding = FragmentCallBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?, binding: ViewBinding) {
        this.binding = binding as FragmentCallBinding
    }
}