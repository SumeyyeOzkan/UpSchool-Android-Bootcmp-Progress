package com.sumeyye.mayis10_cleanarchitecturemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.sumeyye.mayis10_cleanarchitecturemvvm.domain.model.Data
import com.sumeyye.mayis10_cleanarchitecturemvvm.domain.model.WeatherModel
import com.sumeyye.mayis10_cleanarchitecturemvvm.presentation.WeathreViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private val weatherViewModel: WeathreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = weatherViewModel.getWeather("Gaziantep","9af36bc05c43402599b38a6a8dbe4bfb")

        data.observe(this, androidx.lifecycle.Observer {
            Log.v("TAG",data.value.toString())
        })

    }
}