package com.example.talan_app.api


import com.example.talan_app.model.Apikey
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*


interface SimpleApi {
//    @Headers("Content-Type: application/json","MAXAUTH: Qi5XQUxJRDpXYjEyMzQ1Njs=")
    @POST("create")
    suspend fun getlogin(@Body expiration: RequestBody): Response<Apikey>


}