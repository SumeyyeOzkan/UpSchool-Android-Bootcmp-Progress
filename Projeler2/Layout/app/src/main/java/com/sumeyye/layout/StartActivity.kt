package com.sumeyye.layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sumeyye.layout.databinding.ActivityMainBinding
import com.sumeyye.layout.databinding.ActivityPremiumBinding
import com.sumeyye.layout.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_start)

        binding.button2.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val intent: Intent = Intent(this,PremiumActivity::class.java)
        startActivity(intent)
    }
}