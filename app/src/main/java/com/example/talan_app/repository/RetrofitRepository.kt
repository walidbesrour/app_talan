package com.example.talan_app.repository

import com.example.talan_app.api.RetrofitInstance
import com.example.talan_app.model.Apikey
import okhttp3.RequestBody
import retrofit2.Response


class RetrofitRepository {

    suspend fun getlogin(expiration: RequestBody,base64: String): Response<Apikey> {
        return RetrofitInstance.api.getlogin(expiration,base64)
    }
}