package com.aho.assignment.plantsmvpimpl.persistences.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.aho.assignment.plantsmvpimpl.data.vos.LoginInfo

@Dao
abstract class LoginInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUserInfo(loginInfo: LoginInfo)

}