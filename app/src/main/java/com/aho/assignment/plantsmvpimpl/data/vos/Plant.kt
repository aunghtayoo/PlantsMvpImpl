package com.aho.assignment.plantsmvpimpl.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity(tableName = "plant", indices = [Index(value = ["plant_id"], unique = true)])
data class Plant (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "plant_id_pk")
    var plantIdPk: Int,

    @SerializedName("plant_id")
    @ColumnInfo(name = "plant_id")
    var plantId: String,

    @SerializedName("plant_name")
    @ColumnInfo(name = "plant_name")
    var plantName: String,

    @SerializedName("plant_type")
    @ColumnInfo(name = "plant_type")
    var plantType: List<String>,

    @ColumnInfo(name = "description")
    var description: String,

    @SerializedName("top_tip")
    @ColumnInfo(name = "top_tip")
    var topTip: String,

    var tips: Tips,

    @SerializedName("uploaded_user")
    var uploadedUser: User,

    @SerializedName("plant_photo")
    @ColumnInfo(name = "plant_photo")
    var plantPhoto: String,


    @ColumnInfo(name = "favourite_flag")
    @NotNull
    var favouriteFlag: Int = 0

)