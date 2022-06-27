package com.sumeyye.sm.basket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sumeyye.sm.databinding.ItemBagBinding
import com.sumeyye.sm.model.ClothesBasketRoomModel
import com.sumeyye.sm.model.ClothesModel

class ClothesBasketAdapter : RecyclerView.Adapter<ClothesBasketAdapter.ClothesBasketItemDesign>() {

    private val clothesFilterList = ArrayList<ClothesModel>()
    var onRemoveBasketClick: (Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothesBasketItemDesign {
        val clothesBasketItemBinding =  ItemBagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClothesBasketItemDesign(clothesBasketItemBinding)
    }

    override fun onBindViewHolder(holder: ClothesBasketItemDesign, position: Int) {
        holder.bind(clothesFilterList[position])
    }

    inner class ClothesBasketItemDesign(private var itemBagBinding: ItemBagBinding) :
        RecyclerView.ViewHolder(itemBagBinding.root) {

        fun bind(clothesBasket: ClothesModel) {

            itemBagBinding.apply {

                clothesModel = clothesBasket

                clothesBasket.image?.let {
                    Picasso.get().load(it).into(imageView3)
                }

                button4.setOnClickListener {
                    clothesBasket.id?.let{
                        onRemoveBasketClick(it)
                    }

                }
            }
        }
    }

    override fun getItemCount(): Int {
        return clothesFilterList.size
    }

    fun updateList(list: List<ClothesModel>) {
        clothesFilterList.clear()
        clothesFilterList.addAll(list)
        notifyDataSetChanged()
    }
}