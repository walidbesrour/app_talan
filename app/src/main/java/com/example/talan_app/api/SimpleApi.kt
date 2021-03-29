package com.example.talan_app.api


import com.example.talan_app.model.Expiration
import retrofit2.Response
import retrofit2.http.*


interface SimpleApi {
    @Headers("Content-Type: application/json","MAXAUTH: Qi5XQUxJRDpXYjEyMzQ1Njs=")
    @POST("apitoken/create")
    suspend fun getlogin(@Body expiration: Expiration): Response<String>


}