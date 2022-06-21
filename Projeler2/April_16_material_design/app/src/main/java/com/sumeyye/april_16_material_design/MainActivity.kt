package com.sumeyye.april_16_material_design

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var image:ImageView
    private lateinit var button: Button

    private lateinit var image1:ImageView
    private lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.imageView)
        button=findViewById(R.id.button)
        val anim =AnimationUtils.loadAnimation(this,R.anim.my_anim)

        image1=findViewById(R.id.imageView2)
        button2=findViewById(R.id.button4)
        val frameanin=image1.drawable as AnimationDrawable

        button.setOnClickListener{
            image.startAnimation(anim)
        }

        button2.setOnClickListener {
            frameanin.start()
        }

    }
}