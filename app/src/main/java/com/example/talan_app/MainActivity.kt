package com.example.talan_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
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
        println("//////////////////////////////////////////////")
///////////////////////////////////// test Retrofit ////////////////////////////////////////////
        val repository = RetrofitRepository()
        val viewModelFactory = LoginFactory_VM(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(Login_VM::class.java)
//        val expiration = Expiration(-1)
        val jsonObject = JSONObject()
        jsonObject.put("expiration", -1)
        val jsonObjectString = jsonObject.toString()
        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())

        viewModel.getloginAPI(requestBody)

        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
//                Log.d("response **", response.body().toString())
                println("*********************************")
            } else {
                Log.d("response --", response.code().toString())
                Log.d("response --", response.message().toString())
                println("+++++++++++++++++++++++++++++++++++++")
            }
        })

///////////////////////////////////////////////////////////////////////////////////////////////////////////


        binding.b1.setOnClickListener {

            var name = binding.FirstName1.text.toString()
            var password = binding.passwordProfile1.text.toString()
            base64(name,password)
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

    fun base64( a : String , b :String){
        var c = "$a:$b"
        val encodedString: String = Base64.getEncoder().encodeToString(c.toByteArray())

        println(encodedString)
    }
}