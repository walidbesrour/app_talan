package com.example.talan_app.repository

import android.util.Log
import com.example.talan_app.api.RetrofitInstance

import com.example.talan_app.model.Actifs
import com.example.talan_app.model.Apikey
import com.example.talan_app.model.Compteurs
import okhttp3.RequestBody
import retrofit2.Response


class RetrofitRepository {

    suspend fun getlogin(expiration: RequestBody,base64: String): Response<Apikey> {
        return RetrofitInstance.api.getlogin(expiration,base64)
    }

    suspend fun getListActif(apikey: String,select: String,pageSize: Int,pageno: Int): Response<Actifs> {
        return RetrofitInstance.Myapi.getListActif(apikey,select,pageSize,pageno)
    }

    suspend fun getListActifFils(apikey: String,select: String,parent: String,siteid: String): Response<Actifs> {

        return RetrofitInstance.Myapi.getListFils(apikey,select,parent,siteid)
    }

    suspend fun getDetailActif(apikey: String,ASSETNUM: String ,Myselect: String): Response<Actifs> {

        return RetrofitInstance.Myapi.getDetailActif(apikey,ASSETNUM,Myselect)
    }

    suspend fun getCompteurActif(apikey: String,ASSETNUM: String ,Myselect: String): Response<Compteurs> {

        return RetrofitInstance.Myapi.getCompteurActif(apikey,ASSETNUM,Myselect)
    }


}