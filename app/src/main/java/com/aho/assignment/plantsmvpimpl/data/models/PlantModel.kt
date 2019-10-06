package com.aho.assignment.plantsmvpimpl.data.models

import com.aho.assignment.plantsmvpimpl.data.vos.LoginInfo
import com.aho.assignment.plantsmvpimpl.data.vos.LoginUserInfo
import com.aho.assignment.plantsmvpimpl.data.vos.Plant

interface PlantModel {

    fun getAllPlants(
        onSuccess: (List<Plant>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun doLogin(
        loginInfo: LoginInfo,
        onSuccess: (LoginUserInfo) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getPlantById(plantId: String): Plant

    fun getFavouritesPlantList(): List<Plant>

    fun searchPlantInfo(searchKeyWord: String): List<Plant>

    fun updatePlantFavourite(plantId: String) : Int
}