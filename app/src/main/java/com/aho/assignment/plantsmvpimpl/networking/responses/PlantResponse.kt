package com.aho.assignment.plantsmvpimpl.networking.responses

import com.aho.assignment.plantsmvpimpl.data.vos.Plant

data class PlantResponse(
    val message: String,
    val code: Int,
    val data: List<Plant>
)