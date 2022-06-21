package com.sumeyye.april30_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.sumeyye.april30_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickHandlerinterface {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var onClickHandlerinterface: OnClickHandlerinterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val list=ArrayList<ClothesModel>()
        list.add(ClothesModel("Fit and Fylare", "$120.99",R.drawable.clothes1))
        list.add(ClothesModel("Empire Dress", "$136.00",R.drawable.clothes2))
        list.add(ClothesModel("Summer Vibes", "$199.99",R.drawable.clothes3))
        list.add(ClothesModel("Flora Fun ", "$150.99",R.drawable.clothes4))

        onClickHandlerinterface=this //tetiklenecek yer bu class

        //adaptöre ulaşırız
        val adapter=ClothesAdapter(list,onClickHandlerinterface)
        val gridLayoutManager=GridLayoutManager(this,2)
        activityMainBinding.recyclerView.layoutManager=gridLayoutManager
        activityMainBinding.setVariable(BR.adapter,adapter)

    }

    override fun onClick(view: View, position: Int) {
        when(view.id){
            R.id.clothes_button -> {
                Toast.makeText(this,"TIKLANDI- ${position}",Toast.LENGTH_LONG).show()
            }
        }
       //tıklandığında tetiklenecek
    }
}