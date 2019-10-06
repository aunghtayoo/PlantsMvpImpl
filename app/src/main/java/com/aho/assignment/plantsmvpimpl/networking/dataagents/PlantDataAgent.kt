package com.aho.assignment.plantsmvpimpl.networking.dataagents

import com.aho.assignment.plantsmvpimpl.data.vos.LoginInfo
import com.aho.assignment.plantsmvpimpl.data.vos.LoginUserInfo
import com.aho.assignment.plantsmvpimpl.data.vos.Plant

interface PlantDataAgent {

    fun getPlants(
        onSuccess: (List<Plant>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun doLogin(
        loginInfo: LoginInfo,
        onSuccess: (LoginUserInfo) -> Unit,
        onFailure: (String) -> Unit
    )
}