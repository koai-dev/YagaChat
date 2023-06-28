package com.rbservice.yaga.ui.welcome

import android.os.Bundle
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.rbservice.yaga.base.FaFragment
import com.rbservice.yaga.databinding.FragmentWelcomeBinding

class WelcomeFragment : FaFragment() {
    private lateinit var binding: FragmentWelcomeBinding
    override fun getBindingView(container: ViewGroup?)= FragmentWelcomeBinding.inflate(layoutInflater)
    override fun initView(savedInstanceState: Bundle?, binding: ViewBinding) {
        this.binding = binding as FragmentWelcomeBinding

    }
}