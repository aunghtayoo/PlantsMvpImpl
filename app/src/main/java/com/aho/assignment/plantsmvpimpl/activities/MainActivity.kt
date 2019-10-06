package com.aho.assignment.plantsmvpimpl.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aho.assignment.plantsmvpimpl.R
import com.aho.assignment.plantsmvpimpl.activities.DetailActivity.Companion.newDetailIntent
import com.aho.assignment.plantsmvpimpl.activities.FavListActivity.Companion.newFavListIntent
import com.aho.assignment.plantsmvpimpl.adapters.PlantListRVAdapter
import com.aho.assignment.plantsmvpimpl.data.vos.Plant
import com.aho.assignment.plantsmvpimpl.mvp.presenters.LoginResultPresenter
import com.aho.assignment.plantsmvpimpl.mvp.presenters.PlantListPresenter
import com.aho.assignment.plantsmvpimpl.mvp.views.PlantListView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_view_plant.*

class MainActivity : BaseActivity(), PlantListView {

    //declare presenter.
    private lateinit var mPresenter: PlantListPresenter

    //initialize rv_adapter
    private lateinit var mAdapter: PlantListRVAdapter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize presenter
        mPresenter = PlantListPresenter()
        mPresenter.initPresenter(this)

        //initialize adapter
        mAdapter = PlantListRVAdapter(mPresenter)

        //set adapter to rv.
        with(rv_plants){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapter
        }

        ic_subject.setOnClickListener {
            mPresenter.onTabItemFavourite()
        }

        ic_search.setOnClickListener {
            val searchWord = txt_search.text.toString()
            mPresenter.onSearchPlantInfo(searchWord)
        }

        mPresenter.onCreate()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun displayDetail(plantId: String) {
        startActivity(newDetailIntent(applicationContext, plantId))
    }

    override fun displayErrorMessage(message: String) {
        displaySnackBarMessage(message)
    }

    override fun displayFavouritesList() {
        startActivity(newFavListIntent(applicationContext))
    }

    override fun displayPlantsList(plants: List<Plant>) {
        mAdapter.setNewData(plants.toMutableList())
    }

    override fun displaySearchPlantsList(plants: List<Plant>) {
        mAdapter.setNewData(plants.toMutableList())
    }
}
