package com.aho.assignment.plantsmvpimpl.activities

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : AppCompatActivity(){
    protected fun displaySnackBarMessage(message: String){
        Snackbar.make(window.decorView, message, Snackbar.LENGTH_SHORT).show()
    }
}