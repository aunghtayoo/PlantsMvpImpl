package com.aho.assignment.plantsmvpimpl.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aho.assignment.plantsmvpimpl.R
import com.aho.assignment.plantsmvpimpl.data.vos.Plant
import com.aho.assignment.plantsmvpimpl.delegates.PlantListDelegate
import com.aho.assignment.plantsmvpimpl.views.viewholder.PlantsListViewHolder

class PlantListRVAdapter(private val delegate: PlantListDelegate) : BaseRVAdapter<PlantsListViewHolder,Plant>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantsListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_plant, parent, false)
        return PlantsListViewHolder(view, delegate)
    }
}