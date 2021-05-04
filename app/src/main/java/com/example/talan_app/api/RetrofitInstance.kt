package com.example.talan_app.api


import android.util.Log
import com.example.talan_app.MainActivity
import com.example.talan_app.MainActivity.Companion.URL_BASE
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {


    var BASE_URL = "http://192.168.111.10:80/maximo/oslc/"
//    private  const val BASE_URL  ="http://192.168.111.10:80/maximo/oslc/apitoken/"

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor())
    }
            .build()

    private val retrofit by lazy {

        Log.e("****** new url ********", MainActivity.URL_BASE)

        Retrofit.Builder()
                .baseUrl(URL_BASE)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }


    private val retrofit2 by lazy {

        Log.e("****** new url ********", MainActivity.URL_BASE)

        Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    val Myapi: SimpleApi by lazy {
        retrofit2.create(SimpleApi::class.java)

    }


}
