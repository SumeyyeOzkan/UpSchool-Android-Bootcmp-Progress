package com.sumeyye.mayis10_cleanarchitecturemvvm.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sumeyye.mayis10_cleanarchitecturemvvm.domain.model.WeatherModel
import com.sumeyye.mayis10_cleanarchitecturemvvm.domain.usecase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeathreViewModel @Inject constructor(private val useCase: WeatherUseCase):ViewModel() {

    fun getWeather(city:String,key:String): LiveData<WeatherModel> {
        useCase.getWeather(city,key)
        return useCase.getCurrentWeather
    }
}