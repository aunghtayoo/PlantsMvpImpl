package com.aho.assignment.plantsmvpimpl.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aho.assignment.plantsmvpimpl.R
import com.aho.assignment.plantsmvpimpl.adapters.FragmentTabAdapter
import com.aho.assignment.plantsmvpimpl.data.vos.Plant
import com.aho.assignment.plantsmvpimpl.mvp.presenters.FavListPresenter
import com.aho.assignment.plantsmvpimpl.mvp.presenters.PlantListPresenter
import com.aho.assignment.plantsmvpimpl.mvp.views.FavListView
import kotlinx.android.synthetic.main.content_favourites_view.*

class FavListActivity : BaseActivity(), FavListView {

    //declare presenter.
    private lateinit var mPresenter: FavListPresenter

    //declare adapter.
    private lateinit var mAdapter: FragmentTabAdapter

    companion object{
        fun newFavListIntent(context: Context) : Intent{
            return Intent(context, FavListActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_favourites_view)

        //initialize presenter
        mPresenter = FavListPresenter()
        mPresenter.initPresenter(this)

        //initialize adapter
        mAdapter = FragmentTabAdapter(supportFragmentManager)
        vp_favourite.adapter = mAdapter
        tab_layout.setupWithViewPager(vp_favourite)

        mPresenter.onCreate()

    }

}
