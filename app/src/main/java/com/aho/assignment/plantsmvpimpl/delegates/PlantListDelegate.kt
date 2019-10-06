package com.aho.assignment.plantsmvpimpl.delegates

interface PlantListDelegate {
    fun onTabPlantItem(plantId: String)
    fun onSearchPlantInfo(searchWord: String)
    fun onTabItemFavourite()
    fun onTabFavMenu()
    fun onTabFavIcon(plantId: String)
}