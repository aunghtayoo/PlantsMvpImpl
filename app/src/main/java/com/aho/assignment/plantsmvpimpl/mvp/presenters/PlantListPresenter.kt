package com.aho.assignment.plantsmvpimpl.mvp.presenters

import com.aho.assignment.plantsmvpimpl.data.models.PlantModelImpl
import com.aho.assignment.plantsmvpimpl.data.vos.Plant
import com.aho.assignment.plantsmvpimpl.delegates.PlantListDelegate
import com.aho.assignment.plantsmvpimpl.mvp.views.PlantListView
import com.aho.assignment.plantsmvpimpl.persistences.PlantDatabase

class PlantListPresenter : BasePresenter<PlantListView>(), PlantListDelegate {

    override fun onTabPlantItem(plantId: String) {
        mView.displayDetail(plantId)
    }

    override fun onTabFavIcon(plantId: String) {
        PlantModelImpl.updatePlantFavourite(plantId)
    }

    override fun onSearchPlantInfo(searchWord: String) {
        //do something.
        val model = PlantModelImpl
        val plants = model.searchPlantInfo(searchWord)
        mView.displaySearchPlantsList(plants)
    }

    override fun onTabItemFavourite() {
        mView.displayFavouritesList()
    }

    override fun onTabFavMenu() {
        mView.displayFavouritesList()
    }

    override fun onCreate() {
        super.onCreate()

        val model = PlantModelImpl

        model.getAllPlants(
            {
                mView.displayPlantsList(it)
            },{
                mView.displayErrorMessage(it)
            }
        )
    }

}