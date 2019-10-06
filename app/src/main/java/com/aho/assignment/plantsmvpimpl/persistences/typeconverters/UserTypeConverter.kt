package com.aho.assignment.plantsmvpimpl.persistences.typeconverters

import androidx.room.TypeConverter
import com.aho.assignment.plantsmvpimpl.data.vos.User
import com.google.gson.Gson

class UserTypeConverter {

    @TypeConverter
    fun toString(user: User): String {
        return Gson().toJson(user)
    }

    @TypeConverter
    fun toUser(json: String) : User {
        return Gson().fromJson(json, User::class.java)
    }
}