package com.aho.assignment.plantsmvpimpl.data.models

import android.content.Context
import com.aho.assignment.plantsmvpimpl.networking.dataagents.PlantDataAgentImpl
import com.aho.assignment.plantsmvpimpl.persistences.PlantDatabase

abstract class BaseModel {

    protected val dataAgent: PlantDataAgentImpl = PlantDataAgentImpl

    protected lateinit var database: PlantDatabase

    fun initDatabase(context: Context){
        database = PlantDatabase.getInstance(context)
    }

}