package com.sumeyye.sm.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sumeyye.sm.HomeFragmentDirections
import com.sumeyye.sm.databinding.ItemClothesBinding
import com.sumeyye.sm.model.ClothesBasketRoomModel
import com.sumeyye.sm.model.ClothesModel

class AllClothesAdapter : RecyclerView.Adapter<AllClothesAdapter.ClothesItemDesign>() {

    private val clothesList = ArrayList<ClothesModel>()
    var clothesFilterList = ArrayList<ClothesModel>()
    var onAddBasketClick: (ClothesBasketRoomModel) -> Unit = {}

    init {
        clothesFilterList = clothesList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothesItemDesign {
        val clothesItemBinding =
            ItemClothesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClothesItemDesign(clothesItemBinding)
    }

    override fun onBindViewHolder(holder: ClothesItemDesign, position: Int) {
        holder.bind(clothesFilterList[position])
    }

    inner class ClothesItemDesign(private var clothesItemBinding: ItemClothesBinding) :
        RecyclerView.ViewHolder(clothesItemBinding.root) {

        fun bind(clothes: ClothesModel) {

            clothesItemBinding.apply {

                itemClothes = clothes

                //resimde gelen url alındı.Layoutta pisacco kullanamadığımız için burada tanımladık
                clothes.image.let {
                    Picasso.get().load(it).into(imgroduct)
                }

                imgroduct.setOnClickListener {
                    //nav graph fragmentten gidecek fragmenta yön/direction ver
                    //o sayfada gönderilecek modele göre argument vermek lazım
                    val action =
                        HomeFragmentDirections.actionHomeFragmentToDetailFragment(clothes)
                    it.findNavController().navigate(action)
                }



            imageView2.setOnClickListener {
                    onAddBasketClick(
                        ClothesBasketRoomModel(
                            user=clothes.user,
                            title = clothes.title,
                            price = clothes.price,
                            description = clothes.description,
                            category = clothes.category,
                            image = clothes.image,
                            rate = clothes.rate,
                            count = clothes.count,
                            sale_state = clothes.sale_state

                        )
                    )
                }
            }
        }
    }

    override fun getItemCount(): Int = clothesFilterList.size

    fun updateList(list: List<ClothesModel>) {
        clothesList.clear()
        clothesList.addAll(list)
        notifyDataSetChanged()
    }

}