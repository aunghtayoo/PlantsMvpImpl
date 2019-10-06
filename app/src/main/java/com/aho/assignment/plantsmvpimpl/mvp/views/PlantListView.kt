package com.aho.assignment.plantsmvpimpl.mvp.views

import com.aho.assignment.plantsmvpimpl.data.vos.Plant

interface PlantListView : BaseView {
    fun displayPlantsList(plants: List<Plant>)
    fun displaySearchPlantsList(plants: List<Plant>)
    fun displayFavouritesList()
    fun displayDetail(plantId: String)
    fun displayErrorMessage(message: String)
}