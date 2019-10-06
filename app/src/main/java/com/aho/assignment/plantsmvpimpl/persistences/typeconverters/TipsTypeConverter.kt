package com.aho.assignment.plantsmvpimpl.persistences.typeconverters

import androidx.room.TypeConverter
import com.aho.assignment.plantsmvpimpl.data.vos.Tips
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TipsTypeConverter {

    @TypeConverter
    fun toString(tip: Tips): String{
        return Gson().toJson(tip)
    }

    @TypeConverter
    fun toList(json: String): Tips{
        return Gson().fromJson(json, Tips::class.java)
    }
}