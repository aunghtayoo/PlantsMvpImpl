package com.aho.assignment.plantsmvpimpl.data.models

import com.aho.assignment.plantsmvpimpl.data.vos.*

object PlantModelImpl : PlantModel, BaseModel() {

    override fun searchPlantInfo(searchKeyWord: String): List<Plant> {
        //get search result from room database.
        return database.plantDao().searchPlantsByName(searchKeyWord)
    }

    override fun getFavouritesPlantList(): List<Plant> {
        //get favourites from room database.
        return database.plantDao().getFavouritePlants()
    }

    override fun getPlantById(plantId: String): Plant {
        //get data from room database.
        return database.plantDao().getPlantById(plantId)
    }

    override fun updatePlantFavourite(plantId: String) : Int{
        val flag = database.plantDao().getPlantFavouriteFlag(plantId)
        if(flag == 1){
            database.plantDao().updatePlantUnFavourite(plantId)
            return 0
        } else {
            database.plantDao().updatePlantFavourite(plantId)
            return 1
        }
    }

    override fun getAllPlants(onSuccess: (List<Plant>) -> Unit,
                              onFailure: (String) -> Unit) {

        if(database.areEventsExistInDB()){

            var plants = database.plantDao().getAllPlants()
            onSuccess(plants)

        } else {
            dataAgent.getPlants(
                {
                    database.plantDao().insertPlant(it)
                    onSuccess(it)
                },
                onFailure
            )
        }
    }

    override fun doLogin(
        loginInfo: LoginInfo,
        onSuccess: (LoginUserInfo) -> Unit,
        onFailure: (String) -> Unit
    ) {
         dataAgent.doLogin(
             loginInfo,
             {
                 database.loginUserDao().insertLoginUserInfo(it)
                 onSuccess(it)
             },
             onFailure
         )
    }
}