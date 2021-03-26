package com.example.talan_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.talan_app.databinding.ActivityConfigurationBinding


class ConfigurationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfigurationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfigurationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.b22.setOnClickListener {
            val i = Intent(this , MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in ,android.R.anim.fade_out)
            finish()
        }

        binding.b21.setOnClickListener {
            val view = View.inflate(this,R.layout.dialog_view_configurer_ok,null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.setCancelable(false)

              dialog.findViewById<Button>(R.id.btnok)?.setOnClickListener { dialog.dismiss() }





        }
    }
}