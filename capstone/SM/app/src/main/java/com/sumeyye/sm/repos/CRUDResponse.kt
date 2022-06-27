package com.sumeyye.sm.repos

import com.google.gson.annotations.SerializedName
import com.sumeyye.sm.model.ClothesModel

data class CRUDResponse(
    @SerializedName("status") var status: Int,
    @SerializedName("message") var message: String
    //vt geri dönüşü. Başarılı başarısız. örn.sepetten veri sildiğinde sana dönen değer
)
