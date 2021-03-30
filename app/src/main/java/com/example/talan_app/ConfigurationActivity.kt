package com.example.talan_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.talan_app.data.entity.ConfigurationEntity
import com.example.talan_app.databinding.ActivityConfigurationBinding
import com.example.talan_app.view_model.ConfigurationVM


class ConfigurationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfigurationBinding

    private lateinit var configurationVM: ConfigurationVM
    lateinit var httptxt : String
    lateinit var localhost1 : String
    lateinit var port1: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfigurationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val protocole_http = resources.getStringArray(R.array.protocoleHTTP)
    val arrayAdapter = ArrayAdapter(this,R.layout.dropdown_item, protocole_http)
        binding.protocole2.setAdapter(arrayAdapter)

        configurationVM =  ViewModelProvider(this).get(ConfigurationVM::class.java)

        binding.b22.setOnClickListener {
            val i = Intent(this , MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in ,android.R.anim.fade_out)
            finish()
        }

        binding.b21.setOnClickListener {

            httptxt = binding.protocole2.text.toString()
            localhost1 = binding.numlocalhost.text.toString()
            port1 = binding.numport1.text.toString()


            Log.d("***", port1)
            configurationVM.addconfiguration(ConfigurationEntity(1,"httptxt","localhost","port"))
            var config = ConfigurationEntity(1,httptxt,localhost1,port1)
            configurationVM.updateconfiguration(config)
            if (configurationVM.updateconfiguration(config) != null){
                viewOk()
            }


            configurationVM.getconfiguration(this)!!.observe(this, Observer {


                Log.d("port", it[0].port)
                Log.d("port", it[0].hostname)
                Log.d("port", it[0].protocol)

            })



        }
    }

    fun viewOk(){
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