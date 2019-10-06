package com.aho.assignment.plantsmvpimpl.mvp.presenters

import com.aho.assignment.plantsmvpimpl.data.models.PlantModelImpl
import com.aho.assignment.plantsmvpimpl.mvp.views.RecentFavFragmentView

class RecentFavFragmentPresenter : BasePresenter<RecentFavFragmentView>(){

    override fun onCreate() {
        super.onCreate()

        val favList = PlantModelImpl.getFavouritesPlantList()

        if(favList !== null){
            mView.displayFavList(favList)
        } else {
            mView.displayErrorMessage("No more favourites.")
        }
    }
}