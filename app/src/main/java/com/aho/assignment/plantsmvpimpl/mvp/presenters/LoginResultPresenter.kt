package com.aho.assignment.plantsmvpimpl.mvp.presenters

import com.aho.assignment.plantsmvpimpl.data.models.PlantModelImpl
import com.aho.assignment.plantsmvpimpl.data.vos.LoginInfo
import com.aho.assignment.plantsmvpimpl.delegates.LoginDelegate
import com.aho.assignment.plantsmvpimpl.mvp.views.LoginResultView

class LoginResultPresenter(private val loginInfo: LoginInfo) : BasePresenter<LoginResultView>(), LoginDelegate{

    override fun onDoLogin() {

        val model = PlantModelImpl

        model.doLogin(
            loginInfo,
            {
                //success | for display new activity.
                mView.displayLoginSuccessPage(it)
            },
            {
                //failed | for display error message.
                mView.displayErrorMessage(it)
            }
        )
    }

}