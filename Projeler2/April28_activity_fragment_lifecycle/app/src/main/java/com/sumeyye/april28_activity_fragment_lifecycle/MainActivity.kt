package com.sumeyye.april28_activity_fragment_lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //bunun olmaması aktivitinin yüklenmemesi demektir
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mFragment=BlankFragment()
        val fragmentManager:FragmentManager=supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.frame_layout,mFragment).commit()


    }
}