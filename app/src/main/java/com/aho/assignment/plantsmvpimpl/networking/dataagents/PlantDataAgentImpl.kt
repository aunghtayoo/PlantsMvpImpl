package com.aho.assignment.plantsmvpimpl.networking.dataagents

import com.aho.assignment.plantsmvpimpl.data.vos.LoginInfo
import com.aho.assignment.plantsmvpimpl.data.vos.LoginUserInfo
import com.aho.assignment.plantsmvpimpl.data.vos.Plant
import com.aho.assignment.plantsmvpimpl.networking.PlantsApi
import com.aho.assignment.plantsmvpimpl.networking.responses.PlantResponse
import com.aho.assignment.plantsmvpimpl.networking.responses.UserLoginResponse
import com.aho.assignment.plantsmvpimpl.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object PlantDataAgentImpl : PlantDataAgent{

    private val plantApi: PlantsApi

    init {

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        plantApi = retrofit.create(PlantsApi::class.java)
    }

    override fun getPlants(
        onSuccess: (List<Plant>) -> Unit,
        onFailure: (String) -> Unit) {

        val call = plantApi.getAllPlants()

        call.enqueue(object : Callback<PlantResponse>{

            override fun onResponse(call: Call<PlantResponse>,
                                    response: Response<PlantResponse>) {

                val responseBody = response.body()

                if(responseBody != null){

                    onSuccess(responseBody.data)

                } else {

                    //show failed messages.
                }
            }

            override fun onFailure(call: Call<PlantResponse>, t: Throwable) {
                t.printStackTrace()
                onFailure(t.localizedMessage)
            }
        })
    }

    override fun doLogin(
        loginInfo: LoginInfo,
        onSuccess: (LoginUserInfo) -> Unit,
        onFailure: (String) -> Unit) {

        //val call = plantApi.doLogin(loginInfo.email, loginInfo.password)
        val call = plantApi.doLogin()

        call.enqueue(object : Callback<UserLoginResponse>{

            override fun onResponse(
                call: Call<UserLoginResponse>,
                response: Response<UserLoginResponse>
            ) {

                val responseBody = response.body()

                if(responseBody != null){

                    onSuccess(responseBody.data)

                } else {

                    //show failed message.

                }
            }

            override fun onFailure(call: Call<UserLoginResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }
        })
    }
}