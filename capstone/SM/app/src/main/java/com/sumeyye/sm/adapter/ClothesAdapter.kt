package com.sumeyye.sm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.sumeyye.sm.R
import com.sumeyye.sm.databinding.ItemClothesBinding
import com.sumeyye.sm.model.ClothesModel
import com.squareup.picasso.Picasso

class ClothesAdapter(val list: List<ClothesModel>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val clothesBindig=DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_clothes,parent,false
        )
        return ClothesViewHolder(clothesBindig)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ClothesViewHolder).onBind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class ClothesViewHolder(val clothesBindig: ViewDataBinding)
        :RecyclerView.ViewHolder(clothesBindig.root){

        fun onBind(clothesModel: ClothesModel){
            val binding = clothesBindig as ItemClothesBinding
            Picasso.get().load(clothesModel.image).into(binding.imgroduct)
            binding.itemClothes=clothesModel
        }


    }
}