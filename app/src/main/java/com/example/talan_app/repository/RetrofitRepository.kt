package com.example.talan_app.repository

import com.example.talan_app.api.RetrofitInstance
import com.example.talan_app.model.Expiration
import retrofit2.Response


class RetrofitRepository {

    suspend fun getlogin(expiration: Expiration): Response<String> {
        return RetrofitInstance.api.getlogin(expiration)
    }
}