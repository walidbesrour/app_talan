package com.example.talan_app.api



import com.example.talan_app.model.*
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*


interface SimpleApi {

    @POST("apitoken/create")
    suspend fun getlogin(@Body expiration: RequestBody,@Header("MAXAUTH") base64: String): Response<Apikey>

    @GET("os/PFE_LISTACTIF/?lean=1")
    suspend fun getListActif(
            @Query("apikey") apikey: String,
            @Query("oslc.select") select: String,
            @Query("oslc.pageSize") pageSize: Int,
            @Query("pageno") pageno: Int): Response<Actifs>



    @GET("os/PFE_LISTACTIF/?lean=1")
    suspend fun getListFils(
        @Query("apikey") apikey: String,
        @Query("oslc.select") select: String,
        @Query("oslc.where") parent: String,
        @Query("siteid") siteid: String): Response<Actifs>

    @GET("os/PFEWB_ACTIFDET/?lean=1")
    suspend fun getDetailActif(
        @Query("apikey") apikey: String,
        @Query("oslc.where") ASSETNUM : String,
        @Query("oslc.select") Myselect: String): Response<Actifs>

    @GET("os/PFEWB_ACTIFDET/?lean=1")
    suspend fun getCompteurActif(
        @Query("apikey") apikey: String,
        @Query("oslc.where") ASSETNUM : String,
        @Query("oslc.select") Myselect: String): Response<Compteurs>


    @GET("os/PFEWB_ACTIFDET/?lean=1")
    suspend fun getPieceDetachee(
        @Query("apikey") apikey: String,
        @Query("oslc.where") ASSETNUM : String,
        @Query("oslc.select") Myselect: String): Response<PieceD>

    @GET("os/PFEWB_ACTIFDET/?lean=1")
    suspend fun getRisqueActif(
        @Query("apikey") apikey: String,
        @Query("oslc.where") ASSETNUM : String,
        @Query("oslc.select") Myselect: String): Response<Risque>
}

