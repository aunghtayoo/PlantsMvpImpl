package com.aho.assignment.plantsmvpimpl.networking.responses

import com.aho.assignment.plantsmvpimpl.data.vos.LoginUserInfo

data class UserLoginResponse(
    val message: String,
    val code: Int,
    val data: LoginUserInfo
)