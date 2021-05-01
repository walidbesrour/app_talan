package com.example.talan_app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.talan_app.databinding.ActivitySplashScreenBinding
import com.example.talan_app.repository.RetrofitRepository
import com.example.talan_app.view_model.LoginFactory_VM
import com.example.talan_app.view_model.Login_VM
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.util.*

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    private lateinit var viewModel: Login_VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

            val i = Intent(this , Menu_Activity::class.java)
        startActivity(i)
        overridePendingTransition(android.R.anim.fade_in ,android.R.anim.fade_out)
        finish()



//        binding.test1.alpha = 0f
//        binding.test1.animate().setDuration(6000).alpha(1f).withEndAction {
//            val sharedPreferences_APikye = getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
//            val APikye = sharedPreferences_APikye.getString("SAVE_APIKEY",null)
//            if (APikye== null){
//                val i = Intent(this , MainActivity::class.java)
////            val i = Intent(this , Menu_Activity::class.java)
//                startActivity(i)
//                overridePendingTransition(android.R.anim.fade_in ,android.R.anim.fade_out)
//                finish()
//            }else{
//                AutoLogin()
//            }
//
//
//
//        }

    }




    fun AutoLogin(){

        val sharedPreferences = getSharedPreferences("MY_URL", Context.MODE_PRIVATE)
        val saveString = sharedPreferences.getString("SAVE_MY_URL",null)
        MainActivity.URL_BASE = "saveString.toString()"
        ///////// if url base is null then //////////////////////

        ////////////////////////////////////////////////
        val sharedPreferences2 = getSharedPreferences("Base64", Context.MODE_PRIVATE)
        val LoginBase64 = sharedPreferences2.getString("Login_Base64",null)

        /////////// LOGIN IS STATIC //////////
//        var mybase64 = LoginBase64
        var mybase64 = "Qi5XQUxJRDpXYjEyMzQ1Njs="

        val repository = RetrofitRepository()
        val viewModelFactory = LoginFactory_VM(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(Login_VM::class.java)
//        val expiration = Expiration(-1)
        val jsonObject = JSONObject()
        jsonObject.put("expiration", -1)
        val jsonObjectString = jsonObject.toString()
        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())

        viewModel.getloginAPI(requestBody,mybase64)
        viewModel.myResponse.observe(this, androidx.lifecycle.Observer { Myresponse ->
            if (Myresponse.isSuccessful){
                Log.d("*****", Myresponse.body()!!.apikey)
                println("*********************************")
                ///////////// save apikey //////////////////
                val sharedPreferences = getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
                val editor  = sharedPreferences.edit()
                editor.apply(){ putString("SAVE_APIKEY",Myresponse.body()!!.apikey) }.apply()
                ///////// to go at menu //////////
                val i = Intent(this , Menu_Activity::class.java)
                startActivity(i)
                overridePendingTransition(android.R.anim.fade_in ,android.R.anim.fade_out)
                finish()
            }else{
                Log.d("response --", Myresponse.code().toString())
                Log.d("response --", Myresponse.message().toString())
                println("+++++++++++++++++++++++++++++++++++++")
            }
        })


    }


}