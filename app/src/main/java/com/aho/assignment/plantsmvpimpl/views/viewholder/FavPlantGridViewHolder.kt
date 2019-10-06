package com.aho.assignment.plantsmvpimpl.views.viewholder

import android.view.View
import com.aho.assignment.plantsmvpimpl.data.vos.Plant
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_view_fav_plant.view.*

class FavPlantGridViewHolder(itemView: View) : BaseViewHolder<Plant>(itemView) {

    override fun bindData(data: Plant) {
        Glide.with(itemView)
            .load(data.plantPhoto)
            .into(itemView.img_fav)
    }
}