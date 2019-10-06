package com.aho.assignment.plantsmvpimpl.persistences.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PlantTypeConverter {

    @TypeConverter
    fun toString(plantTypes: List<String>): String {
        return Gson().toJson(plantTypes)
    }

    @TypeConverter
    fun toList(json: String): List<String> {
        val typeToken = object : TypeToken<List<String>>(){}.type
        return Gson().fromJson(json, typeToken)
    }
}