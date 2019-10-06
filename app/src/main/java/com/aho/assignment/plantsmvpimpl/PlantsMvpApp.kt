package com.aho.assignment.plantsmvpimpl

import android.app.Application
import com.aho.assignment.plantsmvpimpl.data.models.PlantModelImpl

class PlantsMvpApp : Application() {

    override fun onCreate() {
        super.onCreate()
        PlantModelImpl.initDatabase(applicationContext)


    }
}