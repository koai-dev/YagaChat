package com.rbservice.yaga.models

data class SettingItem(val icon: Int, val title: String, val description: String, val type: String){
    companion object{
        const val TYPE_PERSON = "person"
        const val TYPE_ACCOUNT = "account"
        const val TYPE_PRIVACY = "privacy"
        const val TYPE_NOTIFICATION = "notification"
        const val TYPE_CHAT = "chat"
        const val TYPE_HELP = "help"
        const val TYPE_INVITE = "invite"
    }
}