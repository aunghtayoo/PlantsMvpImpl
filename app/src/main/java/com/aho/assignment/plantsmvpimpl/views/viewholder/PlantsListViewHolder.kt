package com.aho.assignment.plantsmvpimpl.views.viewholder

import android.view.View
import com.aho.assignment.plantsmvpimpl.R
import com.aho.assignment.plantsmvpimpl.data.vos.Plant
import com.aho.assignment.plantsmvpimpl.delegates.PlantListDelegate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_view_plant.view.*

class PlantsListViewHolder(itemView: View, delegate: PlantListDelegate) : BaseViewHolder<Plant>(itemView) {

    init {
        itemView.setOnClickListener {
            data?.plantId?.let {
                delegate.onTabPlantItem(it)
            }
        }

        itemView.ic_favourite.setOnClickListener {
            data?.plantId?.let {
                delegate.onTabFavIcon(it)
            }
        }
    }

    override fun bindData(data: Plant) {
        itemView.lbl_title.text = data.plantName
        itemView.lbl_person_name.text = data.uploadedUser.name

        Glide.with(itemView)
            .load(data.plantPhoto)
            .into(itemView.img_plant)

        Glide.with(itemView)
            .load(data.uploadedUser.userPhoto)
            .into(itemView.img_person)

        if(data.favouriteFlag == 1) {

            Glide.with(itemView)
                .load(R.drawable.ic_favorite_solid_red)
                .into(itemView.ic_favourite)

        } else {

            Glide.with(itemView)
                .load(R.drawable.ic_favorite_secondary)
                .into(itemView.ic_favourite)
        }
    }

}