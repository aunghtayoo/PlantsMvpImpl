package com.aho.assignment.plantsmvpimpl.activities

import android.os.Bundle
import android.view.View
import com.aho.assignment.plantsmvpimpl.R
import com.aho.assignment.plantsmvpimpl.activities.MainActivity.Companion.newIntent
import com.aho.assignment.plantsmvpimpl.data.vos.LoginInfo
import com.aho.assignment.plantsmvpimpl.data.vos.LoginUserInfo
import com.aho.assignment.plantsmvpimpl.mvp.presenters.LoginResultPresenter
import com.aho.assignment.plantsmvpimpl.mvp.views.LoginResultView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginResultView{

    override fun displayErrorMessage(message: String) {
        displaySnackBarMessage(message)
    }

    override fun displayLoginSuccessPage(userInfo: LoginUserInfo) {
        startActivity(newIntent(applicationContext))
    }

    //declare presenter.
    private lateinit var mPresenter: LoginResultPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginInfo = LoginInfo(
            text_email.text.toString(),
            text_password.text.toString()
        )

        //initialize presenter.
        mPresenter = LoginResultPresenter(loginInfo)
        mPresenter.initPresenter(this)

        btn_login.setOnClickListener {
            mPresenter.onDoLogin()
        }

        mPresenter.onCreate()

    }

    override fun onStart() {
        super.onStart()
        mPresenter.onStart()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.onPause()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

}