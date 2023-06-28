package com.rbservice.yaga.ui.auth.sign_in

import android.os.Bundle
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding
import com.rbservice.yaga.R
import com.rbservice.yaga.base.BaseAction
import com.rbservice.yaga.base.FaFragment
import com.rbservice.yaga.databinding.FragmentSignInBinding

class SignInFragment : FaFragment(), BaseAction {
    private lateinit var binding: FragmentSignInBinding
    override fun getBindingView(container: ViewGroup?): ViewBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_sign_in, container, false)

    override fun initView(savedInstanceState: Bundle?, binding: ViewBinding) {
        this.binding = binding as FragmentSignInBinding

        baseAction = this
    }

    override fun onClick() {
        binding.btnNext.setOnClickListener {

        }
        binding.btnMore.setOnClickListener {

        }
    }

    override fun onObserver() {

    }

    override fun getData() {

    }

}