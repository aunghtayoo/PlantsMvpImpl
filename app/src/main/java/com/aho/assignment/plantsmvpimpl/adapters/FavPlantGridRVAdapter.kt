package com.aho.assignment.plantsmvpimpl.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aho.assignment.plantsmvpimpl.R
import com.aho.assignment.plantsmvpimpl.data.vos.Plant
import com.aho.assignment.plantsmvpimpl.views.viewholder.FavPlantGridViewHolder

class FavPlantGridRVAdapter : BaseRVAdapter<FavPlantGridViewHolder, Plant>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavPlantGridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_fav_plant, parent, false)
        return FavPlantGridViewHolder(view)
    }
}