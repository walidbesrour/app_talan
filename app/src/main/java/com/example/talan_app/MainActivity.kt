package com.example.talan_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.talan_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
      setContentView(binding.root)

        val ttb = AnimationUtils.loadAnimation(this,R.anim.ttb)
        val stb = AnimationUtils.loadAnimation(this,R.anim.stb)
        val btt = AnimationUtils.loadAnimation(this,R.anim.btt)
        val btt2 = AnimationUtils.loadAnimation(this,R.anim.btt2)
        val btt3 = AnimationUtils.loadAnimation(this,R.anim.btt3)
        val btt4 = AnimationUtils.loadAnimation(this,R.anim.btt4)

        binding.logo1.startAnimation(ttb)
        binding.t1.startAnimation(stb)
        binding.t2.startAnimation(stb)
        binding.FirstName.startAnimation(btt)
        binding.passwordProfile.startAnimation(btt2)
        binding.b1.startAnimation(btt3)
        binding.b2.startAnimation(btt4)

        binding.b1.setOnClickListener {
            val i = Intent(this , Menu_Activity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in ,android.R.anim.fade_out)
            finish()
        }

        binding.b2.setOnClickListener {
            val i = Intent(this , ConfigurationActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in ,android.R.anim.fade_out)
            finish()
        }

    }
}