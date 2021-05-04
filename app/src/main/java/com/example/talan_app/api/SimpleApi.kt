package com.example.talan_app.api


import com.example.talan_app.model.Actif
import com.example.talan_app.model.Actifs
import com.example.talan_app.model.Apikey
import com.example.talan_app.view_model.Actif_List_VM
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
            @Query("pageno") pageno: Int,): Response<Actifs>


}

//g5f25o8o