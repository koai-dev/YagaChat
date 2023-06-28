package com.rbservice.yaga.ui.setting

import android.os.Bundle
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.rbservice.yaga.R
import com.rbservice.yaga.base.BaseAction
import com.rbservice.yaga.base.BaseListAdapter
import com.rbservice.yaga.base.FaActivity
import com.rbservice.yaga.base.FaFragment
import com.rbservice.yaga.databinding.FragmentSettingBinding
import com.rbservice.yaga.models.SettingItem
import com.rbservice.yaga.ui.setting.adapter.SettingAdapter
import com.rbservice.yaga.utils.AccountUtil

class SettingFragment : FaFragment(), BaseAction {
    private lateinit var binding: FragmentSettingBinding
    private lateinit var settingAdapter: SettingAdapter
    private lateinit var activity: FaActivity
    override fun getBindingView(container: ViewGroup?): ViewBinding =
        FragmentSettingBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?, binding: ViewBinding) {
        this.binding = binding as FragmentSettingBinding
        activity = requireActivity() as FaActivity
        setRcv()
        baseAction = this
    }

    private fun setRcv() {
        settingAdapter = SettingAdapter()
        settingAdapter.listener = object : BaseListAdapter.BaseAction<SettingItem>{
            override fun click(position: Int, data: SettingItem, code: Int) {

            }

        }
        binding.rcvSettings.adapter = settingAdapter
    }

    override fun onClick() {
        binding.btnBack.setOnClickListener {
            activity.onBackPressedDispatcher.onBackPressed()
        }
        binding.btnLogout.setOnClickListener {
            AccountUtil.user = null
        }
    }

    override fun onObserver() {

    }

    override fun getData() {
        val listSettingItems = ArrayList<SettingItem>()
        if (AccountUtil.isLogin()){
            listSettingItems.add(
                SettingItem(
                    icon = R.drawable.ic_account,
                    title = AccountUtil.user?.name?:"No name",
                    description = AccountUtil.user?.bio?:"",
                    type = SettingItem.TYPE_PERSON
                )
            )
        }

        listSettingItems.add(
            SettingItem(
                icon = R.drawable.ic_account,
                title = "Account",
                description = "Security notification, change number",
                type = SettingItem.TYPE_ACCOUNT
            )
        )
        listSettingItems.add(
            SettingItem(
                icon = R.drawable.ic_lock,
                title = "Privacy",
                description = "Block contacts, disappering message",
                type = SettingItem.TYPE_PRIVACY
            )
        )
        listSettingItems.add(
            SettingItem(
                icon = R.drawable.ic_notification,
                title = "Notification",
                description = "Message, group & call tones",
                type = SettingItem.TYPE_NOTIFICATION
            )
        )
        listSettingItems.add(
            SettingItem(
                icon = R.drawable.ic_baseline_chat,
                title = "Chats",
                description = "Theme, wallpapers, chat history",
                type = SettingItem.TYPE_CHAT
            )
        )
        listSettingItems.add(
            SettingItem(
                icon = R.drawable.ic_help,
                title = "Help",
                description = "Help center, contact us, privacy policy",
                type = SettingItem.TYPE_HELP
            )
        )
        listSettingItems.add(
            SettingItem(
                icon = R.drawable.ic_invite,
                title = "Invite a friend",
                description = "",
                type = SettingItem.TYPE_INVITE
            )
        )
        settingAdapter.submitList(listSettingItems)
    }
}