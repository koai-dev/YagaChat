package com.rbservice.yaga.ui.chat

import android.os.Bundle
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.rbservice.yaga.base.FaFragment
import com.rbservice.yaga.databinding.FragmentChatBinding

class ChatFragment : FaFragment() {
    private lateinit var binding: FragmentChatBinding
    override fun getBindingView(container: ViewGroup?): ViewBinding =
        FragmentChatBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?, binding: ViewBinding) {
        this.binding = binding as FragmentChatBinding
    }
}