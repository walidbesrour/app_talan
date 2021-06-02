package com.example.talan_app.repository

import com.example.talan_app.api.RetrofitInstance
import com.example.talan_app.model.Intervention
import retrofit2.Response

class RetrofitRepositoryIntervention {

    suspend fun getListIntervention(apikey: String,select: String,pageSize: Int,pageno: Int): Response<Intervention> {
        return RetrofitInstance.Myapi.getListIntervention(apikey,select,pageSize,pageno)
    }
}