package com.sumeyye.sm.basket

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sumeyye.sm.model.ClothesBasketRoomModel
import com.sumeyye.sm.repos.ClothesRepository

class ClothesBasketFragmentViewModel(context: Context) : ViewModel() {

    private val clothesRepo = ClothesRepository(context)

    private var _clothesBasket = MutableLiveData<List<ClothesBasketRoomModel>>()
    val clothesBasket: LiveData<List<ClothesBasketRoomModel>>
        get() = _clothesBasket

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        getBooksBasket()
    }

    private fun getBooksBasket() {
        clothesRepo.clothesBasket()
        _clothesBasket = clothesRepo.clothesBasketList
        _isLoading = clothesRepo.isLoading
    }

    fun deleteClothesFromBasket(bookId: Int) {
        clothesRepo.deleteClothesFromBasket(bookId)
        getBooksBasket()
    }
}