package com.sumeyye.layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.sumeyye.layout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //private lateinit var button:Button
    //private lateinit var textView: TextView
    //private lateinit var imageView: ImageView

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //setContentView(R.layout.activity_main) //databinding eklendiği için burası artık silinir

        binding.button.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val intent:Intent= Intent(this,StartActivity::class.java)
        startActivity(intent)
    }
}