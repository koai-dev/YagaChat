package com.rbservice.yaga.ui.status

import android.os.Bundle
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.rbservice.yaga.base.FaFragment
import com.rbservice.yaga.databinding.FragmentStatusBinding

class StatusFragment : FaFragment() {
    private lateinit var binding: FragmentStatusBinding
    override fun getBindingView(container: ViewGroup?) = FragmentStatusBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?, binding: ViewBinding) {
        this.binding = binding as FragmentStatusBinding
    }
}