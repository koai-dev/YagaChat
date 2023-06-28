package com.rbservice.yaga.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.rbservice.yaga.base.FaActivity
import com.rbservice.yaga.databinding.ActivitySplashBinding
import com.rbservice.yaga.ui.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : FaActivity() {

    override fun getBindingView() = ActivitySplashBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?, binding: ViewBinding) {
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            openActivity(MainActivity::class.java, false)
        }
    }
}