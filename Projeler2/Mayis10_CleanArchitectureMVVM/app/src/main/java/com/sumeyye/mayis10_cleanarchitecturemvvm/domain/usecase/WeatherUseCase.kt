package com.sumeyye.mayis10_cleanarchitecturemvvm.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sumeyye.mayis10_cleanarchitecturemvvm.domain.model.WeatherModel
import com.sumeyye.mayis10_cleanarchitecturemvvm.domain.repository.WeatherRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository) {

    private var getCurrenWeatherTemp = MutableLiveData<WeatherModel>()
    val getCurrentWeather:LiveData<WeatherModel> = getCurrenWeatherTemp

    fun getWeather(city:String,key:String){ //LiveData'ya set edeceğimiz için buraya livedata yazmaya gerek yok
        weatherRepository.getCurrent(city,key).enqueue(object : Callback<WeatherModel>{
            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                getCurrenWeatherTemp.value=response.body()
            }

            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                println(t)
            }

        })
    }
}