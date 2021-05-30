package com.example.talan_app.repository

import com.example.talan_app.api.RetrofitInstance
import com.example.talan_app.model.*

import okhttp3.RequestBody
import retrofit2.Response


class RetrofitRepository {

    suspend fun getlogin(expiration: RequestBody,base64: String): Response<Apikey> {
        return RetrofitInstance.api.getlogin(expiration,base64)
    }

    suspend fun getListActif(apikey: String,select: String,pageSize: Int,pageno: Int): Response<Actifs> {
        return RetrofitInstance.Myapi.getListActif(apikey,select,pageSize,pageno)
    }

    suspend fun getActif(apikey: String,parent: String,select: String): Response<Actifs> {
        return RetrofitInstance.Myapi.getActif(apikey,parent,select)
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

    suspend fun getPieceDetachee(apikey: String,ASSETNUM: String ,Myselect: String): Response<PieceD> {

        return RetrofitInstance.Myapi.getPieceDetachee(apikey,ASSETNUM,Myselect)
    }
    suspend fun getRisqueActif(apikey: String,ASSETNUM: String ,Myselect: String): Response<Risque> {

        return RetrofitInstance.Myapi.getRisqueActif(apikey,ASSETNUM,Myselect)
    }

    suspend fun getPrecautionActif(apikey: String,ASSETNUM: String ,Myselect: String): Response<Precaution> {

        return RetrofitInstance.Myapi.getPrecautionActif(apikey,ASSETNUM,Myselect)
    }

    suspend fun getDetailInterv(apikey: String,ASSETNUM: String ,Myselect: String): Response<Actifs> {

        return RetrofitInstance.Myapi.getDetailInterv(apikey,ASSETNUM,Myselect)
    }
}


