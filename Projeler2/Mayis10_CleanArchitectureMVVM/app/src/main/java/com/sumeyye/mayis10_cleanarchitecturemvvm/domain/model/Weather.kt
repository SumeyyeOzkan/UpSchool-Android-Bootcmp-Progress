package com.sumeyye.mayis10_cleanarchitecturemvvm.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("code")
    @Expose
    val code: Int,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("icon")
    @Expose
    val icon: String
)