package com.sumeyye.april30_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.sumeyye.april30_recyclerview.databinding.ItemClothesBinding

//ClothesAdapter kodunu yazdıktan sonra kırmızı olur. İçine implement etmem gerekenleri söyler
//ClothesAdapter üzerine gelip kımızı lambaya tıklayıp implement seçtikten sonra seçilmesi gereken 3 şeyi seç ve oluştur

class ClothesAdapter(val list:List<ClothesModel>, val onClickHandlerinterface: OnClickHandlerinterface):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val clothesBinding=DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),R.layout.item_clothes,parent,false
        )
        return ClothesViewHolder(clothesBinding,onClickHandlerinterface)  //ampüle tıklayıp paremetre ekleriz. refactor ederiz
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ClothesViewHolder).onBind(list.get(position),position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class ClothesViewHolder(val clothesBinding: ViewDataBinding, val onClickHandlerinterface: OnClickHandlerinterface)
        :RecyclerView.ViewHolder(clothesBinding.root){

        fun onBind(clothesModel: ClothesModel,position: Int){
            val binding= clothesBinding as ItemClothesBinding
            binding.setVariable(BR.itemclothes,clothesModel)
            binding.setVariable(BR.clickHandler,onClickHandlerinterface)
            binding.setVariable(BR.position,position)
        }
    }
}