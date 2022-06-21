package com.sumeyye.may10_apparchitecture_2

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel:ViewModel() {
    init {
        Log.v("GameViewModel","GameViewModel created.")
    }

    override fun onCleared() {
        super.onCleared()
        Log.v("GameViewModel","GameViewModel destroyed!")
    }
}