package com.example.talan_app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
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

        ////////// test //////////
        dataload()

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

                if ((httptxt== "")||(localhost1== "")||(port1== "")){
                    viewError()
                }else{
                    configurationVM.addconfiguration(ConfigurationEntity(1,"httptxt","localhost","port"))
                    var config = ConfigurationEntity(1,httptxt,localhost1,port1)
                    configurationVM.updateconfiguration(config)
                    if (configurationVM.updateconfiguration(config) != null){
                        viewOk()

                        configurationVM.getconfiguration()!!.observe(this, Observer {

                            ///////////// save URL //////////////////
                            var myUrl = it[0].hostname+"://"+it[0].protocol+":"+it[0].port+"/"
                            val sharedPreferences = getSharedPreferences("MY_URL", Context.MODE_PRIVATE)
                            val editor  = sharedPreferences.edit()
                            editor.apply(){ putString("SAVE_MY_URL",myUrl) }.apply()

                            Log.d("===> : ", it[0].hostname+"://"+it[0].protocol+":"+it[0].port)

                        })
                    }
                    else{
                        viewError()
                    }
                }


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
    fun viewError(){
        val view = View.inflate(this,R.layout.dialog_view_erreur_configurer,null)
        val builder = AlertDialog.Builder(this)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)

        dialog.findViewById<Button>(R.id.btnok)?.setOnClickListener { dialog.dismiss() }
    }


    //////////////////////    test ////////////////////////////////
    private fun dataload(){
        val sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE)
        val saveString = sharedPreferences.getString("String_kye","null")
        println("************************************************")
        println("****************  $saveString ********************************")
        Toast.makeText(this,saveString,Toast.LENGTH_LONG).show()
    }

    //////////////////////////////////////////////////
}