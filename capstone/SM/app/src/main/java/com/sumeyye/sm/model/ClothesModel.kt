package com.sumeyye.sm.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

//CLASSLAR BÜYÜK HARFLE BAŞLAR
//package ve functionlar küçük
@Parcelize
data class ClothesModel(
    @SerializedName("id") @Expose var id: Int? = 0,
    @SerializedName("user") @Expose var user: String?,
    @SerializedName("title") @Expose var title: String?,
    @SerializedName("price") @Expose var price: Double?,
    @SerializedName("description") @Expose var description: String?,
    @SerializedName("category") @Expose var category: String?,
    @SerializedName("image") @Expose var image: String?,
    @SerializedName("rate") @Expose var rate: Double?,
    @SerializedName("count") @Expose var count: Int?,
    @SerializedName("sale_state") @Expose var sale_state:Int?
) : Parcelable
