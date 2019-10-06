package com.aho.assignment.plantsmvpimpl.mvp.views

import com.aho.assignment.plantsmvpimpl.data.vos.LoginUserInfo

interface LoginResultView : BaseView{
    fun displayErrorMessage(message: String)
    fun displayLoginSuccessPage(userInfo: LoginUserInfo)
}