package com.example.talan_app.repository

import com.example.talan_app.api.RetrofitInstance

import com.example.talan_app.model.Services
import retrofit2.Response

class RetrofitRepositoryService {
    suspend fun getListService(apikey: String,select: String,pageSize: Int,pageno: Int): Response<Services> {
        return RetrofitInstance.Myapi.getListService(apikey,select,pageSize,pageno)
    }
}