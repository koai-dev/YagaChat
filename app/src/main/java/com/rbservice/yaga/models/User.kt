package com.rbservice.yaga.models

data class User(
    val id: Int,
    val userId: String,
    val avatar: String,
    val name: String,
    val bio: String,
    val age: Int,
    val statusOnline: String,
    val accessToken: String,
)