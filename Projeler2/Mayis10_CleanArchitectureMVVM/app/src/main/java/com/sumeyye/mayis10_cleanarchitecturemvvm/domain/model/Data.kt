package com.sumeyye.mayis10_cleanarchitecturemvvm.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("app_temp")
    @Expose
    val app_temp: Double,
    @SerializedName("aqi")
    @Expose
    val aqi: Int,
    @SerializedName("city_name")
    @Expose
    val city_name: String,
    @SerializedName("clouds")
    @Expose
    val clouds: Int,
    @SerializedName("country_code")
    @Expose
    val country_code: String,
    @SerializedName("datetime")
    @Expose
    val datetime: String,
    @SerializedName("dewpt")
    @Expose
    val dewpt: Int,
    @SerializedName("dhi")
    @Expose
    val dhi: Int,
    @SerializedName("dni")
    @Expose
    val dni: Int,
    @SerializedName("elev_angle")
    @Expose
    val elev_angle: Double,
    @SerializedName("ghi")
    @Expose
    val ghi: Int,
    @SerializedName("h_angle")
    @Expose
    val h_angle: Int,
    @SerializedName("lat")
    @Expose
    val lat: Double,
    @SerializedName("lon")
    @Expose
    val lon: Double,
    @SerializedName("ob_time")
    @Expose
    val ob_time: String,
    @SerializedName("pod")
    @Expose
    val pod: String,
    @SerializedName("precip")
    @Expose
    val precip: Int,
    @SerializedName("pres")
    @Expose
    val pres: Double,
    @SerializedName("rh")
    @Expose
    val rh: Int,
    @SerializedName("slp")
    @Expose
    val slp: Int,
    @SerializedName("snow")
    @Expose
    val snow: Int,
    @SerializedName("solar_rad")
    @Expose
    val solar_rad: Int,
    @SerializedName("state_code")
    @Expose
    val state_code: String,
    @SerializedName("station")
    @Expose
    val station: String,
    @SerializedName("sunrise")
    @Expose
    val sunrise: String,
    @SerializedName("sunset")
    @Expose
    val sunset: String,
    @SerializedName("temp")
    @Expose
    val temp: Int,
    @SerializedName("timezone")
    @Expose
    val timezone: String,
    @SerializedName("ts")
    @Expose
    val ts: Int,
    @SerializedName("uv")
    @Expose
    val uv: Int,
    @SerializedName("vis")
    @Expose
    val vis: Int,
    @SerializedName("weather")
    @Expose
    val weather: Weather,
    @SerializedName("wind_cdir")
    @Expose
    val wind_cdir: String,
    @SerializedName("wind_cdir_full")
    @Expose
    val wind_cdir_full: String,
    @SerializedName("wind_dir")
    @Expose
    val wind_dir: Int,
    @SerializedName("wind_spd")
    @Expose
    val wind_spd: Double
)