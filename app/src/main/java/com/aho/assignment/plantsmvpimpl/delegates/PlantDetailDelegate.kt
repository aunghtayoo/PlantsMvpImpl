package com.aho.assignment.plantsmvpimpl.delegates

import com.aho.assignment.plantsmvpimpl.data.vos.Plant

interface PlantDetailDelegate {
    fun onTabFavourite(plantId: String) : Int
    fun onBackArrowPress()
    fun onInfoShare(plant: Plant)
}