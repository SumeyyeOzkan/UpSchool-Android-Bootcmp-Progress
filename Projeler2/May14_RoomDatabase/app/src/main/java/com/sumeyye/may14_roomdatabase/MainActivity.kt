package com.sumeyye.may14_roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private val sleepViewModel:SleepViewModel by viewModels{
        SleepViewModelFactory((application as SleepAplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sleepViewModel.allNights.observe(this, Observer { allNights ->
            Log.v("AKBANK",allNights.toString())
        })
    }
}