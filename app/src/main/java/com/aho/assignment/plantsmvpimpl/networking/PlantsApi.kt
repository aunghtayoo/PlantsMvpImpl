package com.aho.assignment.plantsmvpimpl.networking

import com.aho.assignment.plantsmvpimpl.data.vos.LoginUserInfo
import com.aho.assignment.plantsmvpimpl.data.vos.Plant
import com.aho.assignment.plantsmvpimpl.networking.responses.PlantResponse
import com.aho.assignment.plantsmvpimpl.networking.responses.UserLoginResponse
import com.aho.assignment.plantsmvpimpl.utils.DO_LOGIN
import com.aho.assignment.plantsmvpimpl.utils.GET_PLANTS
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Path

interface PlantsApi {

    @POST(DO_LOGIN)
    /*fun doLogin(@Path("email") email: String,
                @Path("password") password: String) : Call<UserLoginResponse>*/
    fun doLogin() : Call<UserLoginResponse>

    @POST(GET_PLANTS)
    fun getAllPlants() : Call<PlantResponse>

}