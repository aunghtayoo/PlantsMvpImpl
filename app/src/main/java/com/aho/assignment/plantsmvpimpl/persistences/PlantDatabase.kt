package com.aho.assignment.plantsmvpimpl.persistences

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aho.assignment.plantsmvpimpl.data.vos.*
import com.aho.assignment.plantsmvpimpl.persistences.daos.LoginInfoDao
import com.aho.assignment.plantsmvpimpl.persistences.daos.LoginUserDao
import com.aho.assignment.plantsmvpimpl.persistences.daos.PlantDao
import com.aho.assignment.plantsmvpimpl.persistences.typeconverters.PlantTypeConverter
import com.aho.assignment.plantsmvpimpl.persistences.typeconverters.TipsTypeConverter
import com.aho.assignment.plantsmvpimpl.persistences.typeconverters.UserTypeConverter

@Database(entities = arrayOf(Plant::class, LoginUserInfo::class), version = 16, exportSchema = false)
@TypeConverters(PlantTypeConverter::class, TipsTypeConverter::class, UserTypeConverter::class)
abstract class PlantDatabase : RoomDatabase(){

    abstract fun plantDao(): PlantDao
    abstract fun loginUserDao(): LoginUserDao

    companion object {

        private var instance: PlantDatabase? = null

        fun getInstance(context: Context): PlantDatabase {

            if(instance == null){
                instance = Room.databaseBuilder(context, PlantDatabase::class.java, "PlantDB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }

            var db = instance!!
            return db
        }
    }

    fun areEventsExistInDB() : Boolean{
        return plantDao().getAllPlants().isNotEmpty()
    }
}