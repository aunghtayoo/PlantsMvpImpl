package com.aho.assignment.plantsmvpimpl.mvp.presenters

import com.aho.assignment.plantsmvpimpl.mvp.views.BaseView

abstract class BasePresenter<T : BaseView> {

    protected lateinit var mView: T

    open fun initPresenter(view: T){
        this.mView = view
    }

    open fun onStart(){}

    open fun onCreate(){}

    open fun onPause(){}

    open fun onResume(){}

    open fun onStop(){}

    open fun onDestroy(){}
}