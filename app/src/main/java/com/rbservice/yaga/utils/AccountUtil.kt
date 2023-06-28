package com.rbservice.yaga.utils

import com.rbservice.yaga.models.User

object AccountUtil {
    var user: User? = null
    fun isLogin() = user!=null
}