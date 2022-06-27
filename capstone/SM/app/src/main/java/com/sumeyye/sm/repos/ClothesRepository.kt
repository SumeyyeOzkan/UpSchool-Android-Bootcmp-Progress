package com.sumeyye.sm.repos

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sumeyye.sm.ApiUtils
import com.sumeyye.sm.model.ClothesBasketRoomModel
import com.sumeyye.sm.model.ClothesModel
import com.sumeyye.sm.retrofit.ClothesDao
import com.sumeyye.sm.room.ClothesBasketDao
import com.sumeyye.sm.room.ClothesBasketRoomDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClothesRepository(context: Context) {
    var clothesList = MutableLiveData<List<ClothesModel>>()

    var clothesBasketList = MutableLiveData<List<ClothesBasketRoomModel>>()

    var isLoading = MutableLiveData<Boolean>()

    var isClothesAddedBasket = MutableLiveData<Boolean>()

    private val clothesDIF: ClothesDao = ApiUtils.getClothesDAOInterface()

    private val clothesBasketDao: ClothesBasketDao? =
        ClothesBasketRoomDatabase.clothesBasketRoomDatabase(context)?.clothesBasketDao()

    fun clothes() {
        isLoading.value = true
        clothesDIF.allClothes().enqueue(object : Callback<List<ClothesModel>> {
            override fun onResponse(
                call: Call<List<ClothesModel>>,
                response: Response<List<ClothesModel>>
            ) {
                response.body()?.let {
                    clothesList.value = it
                    isLoading.value = false
                } ?: run {
                    isLoading.value = false
                }

            }

            override fun onFailure(call: Call<List<ClothesModel>>, t: Throwable) {
                //loglar yazdırılabilir
                println(t.message)
            }

        })
    }


    fun clothesBasket() {
        isLoading.value = true

        clothesBasketDao?.getClothesBasket()?.let {
            clothesBasketList.value = it
            isLoading.value = false
        } ?: run {
            isLoading.value = false
        }
    }

    fun addClothesToBasket(clothesModelModel: ClothesBasketRoomModel) {

        clothesBasketDao?.getClothesNamesBasket()?.let {

            isClothesAddedBasket.value = if (it.contains(clothesModelModel.title).not()) {
                clothesBasketDao.addClothesBasket(clothesModelModel)
                true
            } else {
                false
            }
        }
    }

    fun deleteClothesFromBasket(ClothesId: Int) {
        clothesBasketDao?.deleteClothesWithId(ClothesId)
    }

    fun clearBasket() {
        clothesBasketDao?.clearBasket()
    }
}