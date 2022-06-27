package com.sumeyye.sm

import com.sumeyye.sm.retrofit.ClothesDao
import com.sumeyye.sm.retrofit.retrofitClient

class ApiUtils {
    companion object {
        //RETROFİT build edildi
        fun getClothesDAOInterface(): ClothesDao {
            return retrofitClient.getClient("https://canerture.com/api/ecommerce/").create(ClothesDao::class.java)
        }
    }
}