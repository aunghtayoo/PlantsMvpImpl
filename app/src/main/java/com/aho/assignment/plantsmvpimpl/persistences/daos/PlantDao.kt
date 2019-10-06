package com.aho.assignment.plantsmvpimpl.persistences.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aho.assignment.plantsmvpimpl.data.vos.Plant

@Dao
abstract class PlantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPlant(plants: List<Plant>)

    @Query("SELECT * FROM plant")
    abstract fun getAllPlants(): List<Plant>

    @Query("SELECT * FROM plant WHERE plant_id LIKE :plantId LIMIT 1")
    abstract fun getPlantById(plantId: String): Plant

    @Query("SELECT * FROM plant WHERE plant_name LIKE '%' || :plantName || '%'")
    abstract fun searchPlantsByName(plantName: String): List<Plant>

    @Query("SELECT * FROM plant WHERE favourite_flag=1")
    abstract fun getFavouritePlants(): List<Plant>

    @Query("UPDATE plant SET favourite_flag=1 WHERE plant_id LIKE :plantId")
    abstract fun updatePlantFavourite(plantId: String)

    @Query("UPDATE plant SET favourite_flag=0 WHERE plant_id LIKE :plantId")
    abstract fun updatePlantUnFavourite(plantId: String)

    @Query("SELECT favourite_flag FROM plant WHERE plant_id LIKE :plantId")
    abstract fun getPlantFavouriteFlag(plantId: String) : Int
}