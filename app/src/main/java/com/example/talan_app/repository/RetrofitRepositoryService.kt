package com.example.talan_app.repository

import com.example.talan_app.api.RetrofitInstance
import com.example.talan_app.model.Journal
import com.example.talan_app.model.PieceJoint

import com.example.talan_app.model.Services
import retrofit2.Response

class RetrofitRepositoryService {
    suspend fun getListService(apikey: String,select: String,pageSize: Int,pageno: Int): Response<Services> {
        return RetrofitInstance.Myapi.getListService(apikey,select,pageSize,pageno)
    }

    suspend fun getService(apikey: String,ticketid: String,select: String): Response<Services> {
        return RetrofitInstance.Myapi.getService(apikey,ticketid,select)
    }

    suspend fun getServicePiece(apikey: String,ticketid: String,select: String): Response<PieceJoint> {
        return RetrofitInstance.Myapi.getServicePiece(apikey,ticketid,select)
    }

    suspend fun getDetailService(apikey: String,ASSETNUM: String ,Myselect: String): Response<Services> {
        return RetrofitInstance.Myapi.getDetailService(apikey,ASSETNUM,Myselect)
    }

    suspend fun getServicePlanification(apikey: String,ASSETNUM: String ,Myselect: String): Response<Services> {
        return RetrofitInstance.Myapi.getServicePlanification(apikey,ASSETNUM,Myselect)
    }

    suspend fun getServiceAffecter(apikey: String,ASSETNUM: String ,Myselect: String): Response<Services> {
        return RetrofitInstance.Myapi.getServiceAffecter(apikey,ASSETNUM,Myselect)
    }

    suspend fun getServiceActif(apikey: String,ASSETNUM: String ,Myselect: String): Response<Services> {
        return RetrofitInstance.Myapi.getServiceActif(apikey,ASSETNUM,Myselect)
    }

    suspend fun getServiceJournal(apikey: String,ASSETNUM: String ,Myselect: String): Response<Journal> {
        return RetrofitInstance.Myapi.getServiceJournal(apikey,ASSETNUM,Myselect)
    }

    suspend fun getStatusService(apikey: String,select: String): Response<Services> {
        return RetrofitInstance.Myapi.getStatusService(apikey,select)
    }
}