package com.sumeyye.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sumeyye.databinding.databinding.ActivityDataBinding
//import com.sumeyye.databinding.databinding.ActivityMainBinding

class DataActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var  binding: ActivityDataBinding //main adı: DataActivity(Data-Activity) , binding adı tam tersi oluyor ActivityDataBinding (Activity-Data-Binding)
    //private lateinit var binding: ActivityMainBinding //main kısmında databinding kullanıldığı zaman bu kullanılır
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        init()

        //setContentView(R.layout.activity_data)
    }

    private fun init() {
        binding.mybutton.text="binding button" //buradan artık elementlerin tüm işlemlerini yapabilirim. findViewBy.Id yazmaya gerek kalmayacak
        binding.mybutton.setOnClickListener(this) //this yazdıktan sonra üzerinde alt+ enter yapıp let'mainActivity' gelir . Bunu ekleriz. ok de . Butonoa tıklandığında ... yap. satır 29

    }

    override fun onClick(view: View?) { //this de ampüle ok dedikten sonra burası oluşur. p0 olan yere view yazılır. Butona tıklama olayı satır 24 ten geldi
        when(view?.id){ //viewden sonnra soru işareti konulur . çünkü nullable olarak geliyor. when kotlinde if else'dir
            binding.mybutton.id -> { //hangi butona tıklayacağımızı tanımladık
                //tıklandığında yapılmasını istediğimiz olay
            }

        }

    }
}