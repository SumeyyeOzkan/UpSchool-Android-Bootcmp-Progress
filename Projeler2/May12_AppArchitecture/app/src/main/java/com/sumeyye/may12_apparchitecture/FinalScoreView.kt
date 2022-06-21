package com.sumeyye.may12_apparchitecture

import android.util.Log
import androidx.lifecycle.ViewModel

class FinalScoreView {
    class FinalScoreViewModel(private val finalScore:Int):ViewModel(){
        init {
            Log.v("AKBANK","Game Finished ! - Final Score:  ${finalScore}")
        }
    }
}