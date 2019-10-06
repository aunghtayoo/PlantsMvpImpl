package com.aho.assignment.plantsmvpimpl.mvp.views

import com.aho.assignment.plantsmvpimpl.data.vos.Plant

interface RecentFavFragmentView : BaseView{
    fun displayFavList(plant: List<Plant>)
    fun displayErrorMessage(message: String)
}