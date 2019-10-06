package com.aho.assignment.plantsmvpimpl.persistences.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.aho.assignment.plantsmvpimpl.data.vos.LoginUserInfo

@Dao
abstract class LoginUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertLoginUserInfo(userInfo: LoginUserInfo)
}