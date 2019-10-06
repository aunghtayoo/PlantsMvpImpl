package com.aho.assignment.plantsmvpimpl.mvp.presenters

import com.aho.assignment.plantsmvpimpl.data.models.PlantModelImpl
import com.aho.assignment.plantsmvpimpl.data.vos.Plant
import com.aho.assignment.plantsmvpimpl.delegates.PlantDetailDelegate
import com.aho.assignment.plantsmvpimpl.mvp.views.PlantDetailView

class PlantDetailPresenter(private val plantId: String) : BasePresenter<PlantDetailView>(), PlantDetailDelegate {

    override fun onTabFavourite(plantId: String) : Int{
        val flag = PlantModelImpl.updatePlantFavourite(plantId)
        return flag
    }

    override fun onBackArrowPress() {
        mView.backFromDetail()
    }

    override fun onInfoShare(plant: Plant) {
        //do something about share.
    }

    override fun onCreate() {
        super.onCreate()

        val model = PlantModelImpl
        val plant = model.getPlantById(plantId)

        mView.displayDetailPlantInfo(plant)
        mView.displayTips(plant.tips)

    }
}