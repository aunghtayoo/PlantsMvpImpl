package com.aho.assignment.plantsmvpimpl.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aho.assignment.plantsmvpimpl.R
import com.aho.assignment.plantsmvpimpl.data.vos.Plant
import com.aho.assignment.plantsmvpimpl.data.vos.Tips
import com.aho.assignment.plantsmvpimpl.mvp.presenters.PlantDetailPresenter
import com.aho.assignment.plantsmvpimpl.mvp.presenters.PlantListPresenter
import com.aho.assignment.plantsmvpimpl.mvp.views.PlantDetailView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity(), PlantDetailView {

    //declare presenter.
    private lateinit var mPresenter: PlantDetailPresenter

    companion object {
        fun newDetailIntent(context: Context, plantId: String): Intent {
            var intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("ED_PLANT_ID", plantId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val plantId = intent.getStringExtra("ED_PLANT_ID")

        //initialize presenter
        mPresenter = PlantDetailPresenter(plantId)
        mPresenter.initPresenter(this)

        ic_back.setOnClickListener {
            mPresenter.onBackArrowPress()
        }

        ic_favourite_detail.setOnClickListener {
            if(mPresenter.onTabFavourite(plantId) == 1){
                Glide.with(this)
                    .load(R.drawable.ic_favorite_solid_red)
                    .into(ic_favourite_detail)
            } else {
                Glide.with(this)
                    .load(R.drawable.ic_favorite_secondary)
                    .into(ic_favourite_detail)
            }
        }

        mPresenter.onCreate()
    }

    override fun backFromDetail() {
        finish()
    }

    override fun shareDetailInfo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayDetailPlantInfo(plant: Plant) {
        displayDetailInfo(plant)
    }

    override fun displayTips(tips: Tips) {
        displayTipsInfo(tips)
    }


    fun displayDetailInfo(plant: Plant){
        lbl_title_detail.text = plant.plantName
        lbl_person_name.text = plant.uploadedUser.name
        lbl_desc_detail.text = plant.description

        Glide.with(this)
            .load(plant.uploadedUser.userPhoto)
            .into(img_person_detail)

        Glide.with(this)
            .load(plant.plantPhoto)
            .into(img_bg_detail)

        if(plant.favouriteFlag == 1){
            Glide.with(this)
                .load(R.drawable.ic_favorite_solid_red)
                .into(ic_favourite_detail)
        } else {
            Glide.with(this)
                .load(R.drawable.ic_favorite_secondary)
                .into(ic_favourite_detail)
        }
    }

    fun displayTipsInfo(tips: Tips){
        lbl_light_val_detail.text = tips.light
        lbl_temp_val_detail.text = tips.temperature
        lbl_place_val_detail.text = tips.placement
    }
}
