package com.sumeyye.mayis10_cleanarchitecturemvvm.data.source.remote


import com.sumeyye.mayis10_cleanarchitecturemvvm.domain.model.WeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("current")
    fun getWeather(@Query("city") city: String, @Query("key") key:String): Call<WeatherModel>
    //Call kısmı hata verdi. Call 'u import kısmından sildim ve retrofit2'yi ekledim. Düzeldi
    //Call api'ye çağrı atarız
    //city ve key parametreleriyle çağrı yapıyoruz.

}