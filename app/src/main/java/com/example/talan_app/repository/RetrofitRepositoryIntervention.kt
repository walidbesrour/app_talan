package com.example.talan_app.repository

import com.example.talan_app.api.RetrofitInstance
import com.example.talan_app.model.*
import retrofit2.Response

class RetrofitRepositoryIntervention {

    suspend fun getListIntervention(apikey: String,select: String,pageSize: Int,pageno: Int): Response<Intervention> {
        return RetrofitInstance.Myapi.getListIntervention(apikey,select,pageSize,pageno)
    }

    suspend fun getListInterventionFavoris(apikey: String,select: String,bookmark: String): Response<Intervention> {
        return RetrofitInstance.Myapi.getListInterventionFavoris(apikey,select,bookmark)
    }


    suspend fun getDetailFavoris(apikey: String,wonum: String,select: String): Response<Intervention> {
        return RetrofitInstance.Myapi.getDetailFavoris(apikey,wonum,select)
    }

    suspend fun getFilsFavoris(apikey: String,select: String,wonum: String): Response<Intervention> {
        return RetrofitInstance.Myapi.getFilsFavoris(apikey,select,wonum)
    }


    suspend fun getTacheInter(apikey: String,wonum: String,select: String): Response<Tache> {
        return RetrofitInstance.Myapi.getTacheInter(apikey,wonum,select)
    }

    suspend fun getMainInter(apikey: String,wonum: String,select: String): Response<MainDoeuvre> {
        return RetrofitInstance.Myapi.getMainInter(apikey,wonum,select)
    }

    suspend fun getArticleInter(apikey: String,wonum: String,select: String): Response<Articles> {
        return RetrofitInstance.Myapi.getArticleInter(apikey,wonum,select)
    }

    suspend fun getServInter(apikey: String,wonum: String,select: String): Response<ServicesPlan> {
        return RetrofitInstance.Myapi.getServInter(apikey,wonum,select)
    }

    suspend fun getOutilInter(apikey: String,wonum: String,select: String): Response<Outil> {
        return RetrofitInstance.Myapi.getOutilInter(apikey,wonum,select)
    }

    suspend fun getRealisationInter(apikey: String,wonum: String,select: String): Response<MainDoeuvre> {
        return RetrofitInstance.Myapi.getRealisationInter(apikey,wonum,select)
    }

    suspend fun getRisqueInter(apikey: String,wonum: String,select: String): Response<RisqueInter> {
        return RetrofitInstance.Myapi.getRisqueInter(apikey,wonum,select)
    }

    suspend fun getPrecautionInter(apikey: String,wonum: String,select: String): Response<PcautionreInter> {
        return RetrofitInstance.Myapi.getPrecautionInter(apikey,wonum,select)
    }
}

