package com.aho.assignment.plantsmvpimpl.mvp.presenters

import com.aho.assignment.plantsmvpimpl.delegates.FavListDelegate
import com.aho.assignment.plantsmvpimpl.mvp.views.FavListView

class FavListPresenter : BasePresenter<FavListView>(), FavListDelegate{

    override fun onCreate() {
        super.onCreate()
    }
}