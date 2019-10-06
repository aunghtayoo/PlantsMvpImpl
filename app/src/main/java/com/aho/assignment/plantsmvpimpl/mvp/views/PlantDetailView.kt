package com.aho.assignment.plantsmvpimpl.mvp.views

import com.aho.assignment.plantsmvpimpl.data.vos.Plant
import com.aho.assignment.plantsmvpimpl.data.vos.Tips

interface PlantDetailView : BaseView {
    fun displayDetailPlantInfo(plant: Plant)
    fun displayTips(tips: Tips)
    fun backFromDetail()
    fun shareDetailInfo()
}