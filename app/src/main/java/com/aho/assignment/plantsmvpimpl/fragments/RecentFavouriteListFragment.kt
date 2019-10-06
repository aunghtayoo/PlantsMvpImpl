package com.aho.assignment.plantsmvpimpl.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aho.assignment.plantsmvpimpl.R
import com.aho.assignment.plantsmvpimpl.adapters.FavPlantGridRVAdapter
import com.aho.assignment.plantsmvpimpl.data.vos.Plant
import com.aho.assignment.plantsmvpimpl.mvp.presenters.RecentFavFragmentPresenter
import com.aho.assignment.plantsmvpimpl.mvp.views.RecentFavFragmentView
import kotlinx.android.synthetic.main.favourite_list_layout.*
import kotlinx.android.synthetic.main.favourite_list_layout.view.*

class RecentFavouriteListFragment : BaseFragment(), RecentFavFragmentView{

    //declare presenter.
    private lateinit var mPresenter: RecentFavFragmentPresenter

    //declare adapter.
    private lateinit var mAdapter: FavPlantGridRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.favourite_list_layout, container, false)

        //initialize presenter.
        mPresenter = RecentFavFragmentPresenter()
        mPresenter.initPresenter(this)

        mAdapter = FavPlantGridRVAdapter()

        //set adapter to rv.
        with(view.rv_favourite){
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context,2)
            adapter = mAdapter
        }

        mPresenter.onCreate()

        return view
    }

    override fun displayFavList(plant: List<Plant>) {
        mAdapter.setNewData(plant.toMutableList())
    }

    override fun displayErrorMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}