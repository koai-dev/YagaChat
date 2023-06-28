package com.rbservice.yaga.ui.main

import android.os.Bundle
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.rbservice.yaga.R
import com.rbservice.yaga.base.BaseAction
import com.rbservice.yaga.base.FaFragment
import com.rbservice.yaga.databinding.FragmentMainBinding
import com.rbservice.yaga.ui.MainActivity
import com.rbservice.yaga.ui.main.adapter.MainPager

class MainFragment : FaFragment(), BaseAction {
    private lateinit var binding: FragmentMainBinding
    private lateinit var activity: MainActivity
    override fun getBindingView(container: ViewGroup?): ViewBinding =
        DataBindingUtil.inflate(layoutInflater, R.layout.fragment_main, null, false)

    override fun initView(savedInstanceState: Bundle?, binding: ViewBinding) {
        this.binding = binding as FragmentMainBinding
        activity = requireActivity() as MainActivity
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            val paramsTop =
                binding.pointTop.layoutParams as ViewGroup.MarginLayoutParams
            paramsTop.setMargins(
                0,
                insets.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                0,
                0
            )
            binding.pointTop.layoutParams = paramsTop
            insets
        }
        baseAction = this
        setUpPager()
    }

    private fun setUpPager() {
        val pagerAdapter = MainPager(activity)
        binding.pager.adapter = pagerAdapter
        binding.pager.offscreenPageLimit = 4
        TabLayoutMediator(
            binding.tab, binding.pager
        ) { tab, position ->
            when (position) {
                0 -> tab.icon = ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.ic_groups,
                    resources.newTheme()
                )

                1 -> tab.text = resources.getString(R.string.chat)
                2 -> tab.text = resources.getString(R.string.status)
                else -> tab.text = resources.getString(R.string.call)
            }
        }.attach()
    }

    override fun onClick() {

    }

    override fun onObserver() {

    }

    override fun getData() {

    }

}