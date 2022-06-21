package com.sumeyye.april_14_dark_style

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    // private lateinit var switchMaterial: com.google.android.material.switchmaterial.SwitchMaterial // bu şekilde kullanım çok doğru değil , o yüzden com dan sonraki kısmı import'a tanımlarız
    private lateinit var switchMaterial: SwitchMaterial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchMaterial = findViewById(R.id.myswitch)
        switchMaterial.setOnCheckedChangeListener(this) //alt enter deyip let seçiyoruz. 25. satır oluşur
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES) //gece modu sonunda yes var



    }

    override fun onCheckedChanged(view: CompoundButton?, isChecked: Boolean) { //isChecked : Seçildiğinde , view id alacak
        if (isChecked){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) //gündüz modu ile açılacak
        }
    }
}