package com.sumeyye.nisan_12_databinding2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sumeyye.nisan_12_databinding2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var user:User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding =DataBindingUtil.setContentView(this,R.layout.activity_main) //activitiy main bu dosyadan çağırıldığı için this eklenmelidir
        init()
    }
    private fun init(){
        user=User("Sümeyye","ÖZKAN") // BURADAKİ bilgileri/data xml dosyasına gönderilecek
        //binding.user=user //bu şekilde de tanımlama yapılabilir
        binding.setVariable(BR.user,user) //id 'kotlin-kapt' bunu gradle kısmına yükleyince çalışır
    }
}