package com.sumeyye.sm.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sumeyye.sm.model.ClothesBasketRoomModel
import com.sumeyye.sm.model.ClothesModel
import com.sumeyye.sm.repos.ClothesRepository

class ClothesFragmentViewModel(context: Context) : ViewModel() {

    private var clothesRepo = ClothesRepository(context)

    private var _clothesList = MutableLiveData<List<ClothesModel>>()
    val clothesList: LiveData<List<ClothesModel>>
        get() = _clothesList

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private var _isClothesAddedBasket = MutableLiveData<Boolean>()
    val isClothesAddedBasket: LiveData<Boolean>
        get() = _isClothesAddedBasket

    init { //class oluştuğu gibi ilk olarak burası çalışır
        getClothes()
    }

    private fun getClothes() {
        clothesRepo.clothes()
        _clothesList = clothesRepo.clothesList
        _isLoading = clothesRepo.isLoading
    }

    fun addClothesToBasket(clothesModel: ClothesBasketRoomModel) {
        clothesRepo.addClothesToBasket(clothesModel)
        _isClothesAddedBasket = clothesRepo.isClothesAddedBasket
    }
}