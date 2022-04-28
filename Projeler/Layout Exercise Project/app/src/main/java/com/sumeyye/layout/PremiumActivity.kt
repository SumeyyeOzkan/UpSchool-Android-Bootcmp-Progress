package com.sumeyye.layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.text.bold
import androidx.core.text.color
import androidx.core.text.scale
import androidx.databinding.DataBindingUtil
import com.sumeyye.layout.databinding.ActivityPremiumBinding

class PremiumActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPremiumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_premium)
        binding.button3.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent) //activitiy başlatan startActivity'dir . layout ile alakası yok. Tüm androidde öyle. Burada isimler denk gelmiş
    }
}