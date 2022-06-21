package com.sumeyye.may12_apparchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sumeyye.may12_apparchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        val viewModel=ViewModelProvider(this).get(GameViewModel::class.java)
        binding.gameViewModel=viewModel
        binding.setLifecycleOwner(this)

        viewModel.eventGameFinish.observe(this, Observer { isGameFinished ->
            if (isGameFinished){
                Toast.makeText(this,"Game Finished,",Toast.LENGTH_LONG).show()
            }
        })

        /*
        val viewModelFactory=FinalScoreViewModelFactory(10)
        val viewModel=ViewModelProvider(this,viewModelFactory).get(FinalScoreView.FinalScoreViewModel::class.java)
        */


       /*
        val plusButton=findViewById<Button>(R.id.plus_button)
        val minusButton=findViewById<Button>(R.id.minus_button)
        val scoreText=findViewById<TextView>(R.id.scoretxt)

        val viewModel=ViewModelProvider(this).get(GameViewModel::class.java)

        plusButton.setOnClickListener {
            viewModel.OnPlusScore()
        }
        minusButton.setOnClickListener {
            viewModel.OnMinusScore()
        }
        viewModel.score.observe(this, Observer{newScore ->
            scoreText.text=newScore.toString()
        })

        viewModel.eventGameFinish.observe(this, Observer { isGameFinished ->
            if (isGameFinished){
                Toast.makeText(this,"Game Finished,",Toast.LENGTH_LONG).show()
            }
        })

        */
    }
}