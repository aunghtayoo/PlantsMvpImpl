package com.aho.assignment.plantsmvpimpl.data.vos

import com.google.gson.annotations.SerializedName

data class User(

    val name: String,

    @SerializedName("user_photo")
    val userPhoto: String,

    @SerializedName("uploaded_time")
    val uploadedTime: String,

    @SerializedName("user_rank")
    val userRank: String
)