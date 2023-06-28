package com.rbservice.yaga.ui.setting.adapter

import com.rbservice.yaga.R
import com.rbservice.yaga.base.BaseListAdapter
import com.rbservice.yaga.models.SettingItem

class SettingAdapter : BaseListAdapter<SettingItem>() {
    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).type==SettingItem.TYPE_PERSON){
            0
        }else{
            1
        }
    }
    override fun getLayoutId(viewType: Int) = if (viewType==0){
        R.layout.item_setting_account
    }else{
        R.layout.item_setting
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        super.onBindViewHolder(holder, position)

    }
}