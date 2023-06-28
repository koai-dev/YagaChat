package com.rbservice.yaga.ui

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.rbservice.yaga.base.FaActivity
import com.rbservice.yaga.databinding.ActivityMainBinding

class MainActivity : FaActivity() {
    override fun getBindingView(): ViewBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?, binding: ViewBinding) {

    }
}