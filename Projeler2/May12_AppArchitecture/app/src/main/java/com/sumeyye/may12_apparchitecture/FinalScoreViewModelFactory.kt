package com.sumeyye.may12_apparchitecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FinalScoreViewModelFactory(private val finasScore:Int):ViewModelProvider.Factory { //bunu yazdıktan sonra kırmızı ampül çıkar ona tıklayarak implament yapılır
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FinalScoreView.FinalScoreViewModel(finasScore) as T
    }

}