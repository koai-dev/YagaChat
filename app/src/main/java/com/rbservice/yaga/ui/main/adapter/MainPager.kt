package com.rbservice.yaga.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rbservice.yaga.ui.call.CallFragment
import com.rbservice.yaga.ui.chat.ChatFragment
import com.rbservice.yaga.ui.group.GroupFragment
import com.rbservice.yaga.ui.status.StatusFragment

class MainPager(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
       return when(position){
           0->GroupFragment()
           1->ChatFragment()
           2-> StatusFragment()
           else -> CallFragment()
       }
    }
}