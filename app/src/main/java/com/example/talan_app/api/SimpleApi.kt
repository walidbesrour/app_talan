package com.example.talan_app.api


import com.example.talan_app.model.Apikey
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*


interface SimpleApi {

    @POST("maximo/oslc/apitoken/create")
    suspend fun getlogin(@Body expiration: RequestBody,@Header("MAXAUTH") base64: String): Response<Apikey>


}