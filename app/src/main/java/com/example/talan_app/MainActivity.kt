package com.example.talan_app

import android.content.Context
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.talan_app.databinding.ActivityMainBinding
import com.example.talan_app.repository.RetrofitRepository
import com.example.talan_app.view_model.LoginFactory_VM
import com.example.talan_app.view_model.Login_VM
import java.util.*
import androidx.lifecycle.Observer
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: Login_VM
    var name =""
    var password = ""
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

            name = binding.FirstName1.text.toString()
            password = binding.passwordProfile1.text.toString()
            if(name == "" || password == ""){
                viewError()
            }else{
                login(name,password)

            }


        }

        binding.b2.setOnClickListener {

            val i = Intent(this , ConfigurationActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in ,android.R.anim.fade_out)
            finish()
        }

    }


    fun login( a : String , b :String){

        val sharedPreferences = getSharedPreferences("MY_URL", Context.MODE_PRIVATE)
        val saveString = sharedPreferences.getString("SAVE_MY_URL",null)
        URL_BASE = saveString.toString()
        ///////// if url base is null then //////////////////////

        ////////////////////////////////////////////////
        var logAndPas = "$a:$b"
        val encodedString: String = Base64.getEncoder().encodeToString(logAndPas.toByteArray())
        val sharedPreferences2 = getSharedPreferences("Base64", Context.MODE_PRIVATE)
        val editor  = sharedPreferences2.edit()
        editor.apply(){ putString("Login_Base64",encodedString) }.apply()


        /////////// LOGIN IS STATIC //////////
        var mybase64 = encodedString
//        var mybase64 = "Qi5XQUxJRDpXYjEyMzQ1Njs="

        val repository = RetrofitRepository()
        val viewModelFactory = LoginFactory_VM(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(Login_VM::class.java)
//        val expiration = Expiration(-1)
        val jsonObject = JSONObject()
        jsonObject.put("expiration", -1)
        val jsonObjectString = jsonObject.toString()
        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())

        viewModel.getloginAPI(requestBody,mybase64)

        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {

                Log.d("*****", response.body()!!.apikey)
                println("*********************************")
                ///////////// save apikey //////////////////
                val sharedPreferences = getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
                val editor  = sharedPreferences.edit()
                editor.apply(){ putString("SAVE_APIKEY",response.body()!!.apikey) }.apply()
                ///////// to go at menu //////////
                val i = Intent(this , Menu_Activity::class.java)
                startActivity(i)
                overridePendingTransition(android.R.anim.fade_in ,android.R.anim.fade_out)
                finish()


            } else {
                Log.d("response --", response.code().toString())
                Log.d("response --", response.message().toString())
                println("+++++++++++++++++++++++++++++++++++++")
            }
        })

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
    companion object{
        var URL_BASE  ="http://192.168.111.10:80/"

    }

}