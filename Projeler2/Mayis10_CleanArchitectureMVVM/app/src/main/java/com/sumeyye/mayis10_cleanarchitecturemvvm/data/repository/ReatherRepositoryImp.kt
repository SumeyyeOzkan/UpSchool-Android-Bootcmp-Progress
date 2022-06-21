package com.sumeyye.mayis10_cleanarchitecturemvvm.data.repository

import androidx.lifecycle.MutableLiveData
import com.sumeyye.mayis10_cleanarchitecturemvvm.data.source.remote.ApiService
import com.sumeyye.mayis10_cleanarchitecturemvvm.domain.model.WeatherModel
import com.sumeyye.mayis10_cleanarchitecturemvvm.domain.repository.WeatherRepository
import retrofit2.Call

class ReatherRepositoryImp(private val apiService: ApiService):WeatherRepository {
    override fun getCurrent(city: String, key: String): Call<WeatherModel> {
        return apiService.getWeather(city,key)
    }

}