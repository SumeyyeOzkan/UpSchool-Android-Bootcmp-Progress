package com.sumeyye.april28_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Burada yapılan tüm çalışmalar logcat ekranında gözükmektedird.

        Log.v("AKBANK","onCreate Called") //ACTIVITY //logcat ekranında gözükür. logcat arama çubuğuna AKBANK yaz.

    }

    override fun onStart() { //uygulama çalıştığında logcat ekranında gözükür
        super.onStart()
        Log.v("AKBANK","onStart Called") //ACTIVITY
    }

    override fun onResume() {
        super.onResume()
        Log.v("AKBANK","onResume Called") //ACTIVITY
    }

    override fun onPause() { // logcat'te görünmesi için geri tuşuna basılması gerekir
        super.onPause()
        Log.v("AKBANK","onPause Called") //ACTIVITY
    }

    override fun onStop() { //uygulamadan çıkıldıktan sonra komut çalışır
        super.onStop()
        Log.v("AKBANK","onStop Called") //ACTIVITY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("AKBANK","onDestroy Called") //ACTIVITY
    }
}