package com.sumeyye.sm.retrofit

import com.sumeyye.sm.model.ClothesModel
import com.sumeyye.sm.repos.CRUDResponse
import com.sumeyye.sm.repos.ClothesResponse
import retrofit2.Call
import retrofit2.http.GET

interface ClothesDao {
    @GET("https://canerture.com/api/ecommerce/get_products.php") //tüm ürünler
    fun allClothes(): Call<List<ClothesModel>>

    @GET("https://canerture.com/api/ecommerce/get_sale_products.php") //sale product
    fun clothesBasket(): Call<List<ClothesModel>>

    @GET("https://canerture.com/api/ecommerce/get_categories.php") //categories
    fun clothesCategories(): Call<List<String>>
}
