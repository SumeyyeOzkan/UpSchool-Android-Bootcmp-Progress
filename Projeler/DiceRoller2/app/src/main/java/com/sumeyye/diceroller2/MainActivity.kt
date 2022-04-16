package com.sumeyye.diceroller2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button=findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }
        diceImage=findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        val randomInt= Random().nextInt(6)+1
        val drawableResource= when(randomInt){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else ->R.drawable.dice_6
        }
        //val diceImage:ImageView=findViewById(R.id.dice_image) //bu işlemi lateinit ile yaptık
        diceImage.setImageResource(drawableResource)
    }
}