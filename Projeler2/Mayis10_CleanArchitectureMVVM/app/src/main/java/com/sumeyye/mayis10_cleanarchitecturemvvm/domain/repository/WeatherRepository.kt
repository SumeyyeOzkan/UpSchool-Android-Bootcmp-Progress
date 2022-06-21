package com.sumeyye.mayis10_cleanarchitecturemvvm.domain.repository


import androidx.lifecycle.MutableLiveData
import com.sumeyye.mayis10_cleanarchitecturemvvm.domain.model.WeatherModel
import retrofit2.Call

interface WeatherRepository {
    fun getCurrent(city:String, key:String) : Call<WeatherModel>
}
