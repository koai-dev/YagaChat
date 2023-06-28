package com.rbservice.yaga.ui.group

import android.os.Bundle
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.rbservice.yaga.base.FaFragment
import com.rbservice.yaga.databinding.FragmentGroupBinding

class GroupFragment : FaFragment() {
    private lateinit var binding: FragmentGroupBinding
    override fun getBindingView(container: ViewGroup?) = FragmentGroupBinding.inflate(layoutInflater)
    override fun initView(savedInstanceState: Bundle?, binding: ViewBinding) {
       this.binding = binding as FragmentGroupBinding
    }
}