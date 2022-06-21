package com.sumeyye.april30_recyclerview

import android.widget.ImageView
import androidx.databinding.BindingAdapter

class DataBindingAdapter {

    companion object{
        @JvmStatic @BindingAdapter ("imageResource") //buraya imageResource adını verdik bunu alıp item_clothes.xml de kullanıyoruz
        fun setImageResource(imageView: ImageView,resource:Int)
        {
            imageView.setImageResource(resource)
        }
    }
}