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
    suspend fun getActif(
        @Query("apikey") apikey: String,
        @Query("oslc.where") parent: String,
        @Query("oslc.select") select: String

    ): Response<Actifs>

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


    @GET("os/PFEWB_ACTIFDET/?lean=1")
    suspend fun getPrecautionActif(
        @Query("apikey") apikey: String,
        @Query("oslc.where") ASSETNUM : String,
        @Query("oslc.select") Myselect: String): Response<Precaution>



    @GET("os/PFEWB_LISTSR/?lean=1")
    suspend fun getListService(
        @Query("apikey") apikey: String,
        @Query("oslc.select") select: String,
        @Query("oslc.pageSize") pageSize: Int,
        @Query("pageno") pageno: Int): Response<Services>


    @GET("os/PFEWA_SR/?lean=1")
    suspend fun getDetailService(
        @Query("apikey") apikey: String,
        @Query("oslc.where") ASSETNUM : String,
        @Query("oslc.select") Myselect: String): Response<Services>


    @GET("os/PFEWA_SR/?lean=1")
    suspend fun getServicePlanification(
        @Query("apikey") apikey: String,
        @Query("oslc.where") ASSETNUM : String,
        @Query("oslc.select") Myselect: String): Response<Services>

    @GET("os/PFEWA_SR/?lean=1")
    suspend fun getServiceAffecter(
        @Query("apikey") apikey: String,
        @Query("oslc.where") ASSETNUM : String,
        @Query("oslc.select") Myselect: String): Response<Services>

    @GET("os/PFEWA_SR/?lean=1")
    suspend fun getServiceActif(
        @Query("apikey") apikey: String,
        @Query("oslc.where") ASSETNUM : String,
        @Query("oslc.select") Myselect: String): Response<Services>

    @GET("os/PFEWA_SR/?lean=1")
    suspend fun getServiceJournal(
        @Query("apikey") apikey: String,
        @Query("oslc.where") ASSETNUM : String,
        @Query("oslc.select") Myselect: String): Response<Journal>

    @GET("os/PFEWB_ACTIFDET/?lean=1")
    suspend fun getDetailInterv(
        @Query("apikey") apikey: String,
        @Query("oslc.where") ASSETNUM : String,
        @Query("oslc.select") Myselect: String): Response<Actifs>



    @GET("os/PFEWA_LISINV/?lean=1")
    suspend fun getListIntervention(
        @Query("apikey") apikey: String,
        @Query("oslc.select") select: String,
        @Query("oslc.pageSize") pageSize: Int,
        @Query("pageno") pageno: Int): Response<Intervention>



    @GET("os/PFEWA_LISINV/?lean=1")
    suspend fun getListInterventionFavoris(
        @Query("apikey") apikey: String,
        @Query("oslc.select") select: String,
        @Query("oslc.where") bookmark : String): Response<Intervention>

    @GET("os/PFEWA_IN/?lean=1")
    suspend fun getDetailFavoris(
        @Query("apikey") apikey: String,
        @Query("oslc.where") wonum : String,
        @Query("oslc.select") select: String): Response<Intervention>


    @GET("os/PFEWA_INTER/?lean=1")
    suspend fun getFilsFavoris(
        @Query("apikey") apikey: String,
        @Query("oslc.select") select: String,
        @Query("oslc.where") wonum : String): Response<Intervention>


    @GET("os/PFEWA_INTER/?lean=1")
    suspend fun getTacheInter(
        @Query("apikey") apikey: String,
        @Query("oslc.where") wonum : String,
        @Query("oslc.select") select: String): Response<Tache>


    @GET("os/PFEWA_INTER/?lean=1")
    suspend fun getMainInter(
        @Query("apikey") apikey: String,
        @Query("oslc.where") wonum : String,
        @Query("oslc.select") select: String): Response<MainDoeuvre>


    @GET("os/PFEWA_INTER/?lean=1")
    suspend fun getArticleInter(
        @Query("apikey") apikey: String,
        @Query("oslc.where") wonum : String,
        @Query("oslc.select") select: String): Response<Articles>


    @GET("os/PFEWA_INTER/?lean=1")
    suspend fun getServInter(
        @Query("apikey") apikey: String,
        @Query("oslc.where") wonum : String,
        @Query("oslc.select") select: String): Response<ServicesPlan>


    @GET("os/PFEWA_INTER/?lean=1")
    suspend fun getOutilInter(
        @Query("apikey") apikey: String,
        @Query("oslc.where") wonum : String,
        @Query("oslc.select") select: String): Response<Outil>



    @GET("os/PFEWA_INTER/?lean=1")
    suspend fun getRealisationInter(
        @Query("apikey") apikey: String,
        @Query("oslc.where") wonum : String,
        @Query("oslc.select") select: String): Response<MainDoeuvre>


    @GET("os/PFEWA_INTER/?lean=1")
    suspend fun getRisqueInter(
        @Query("apikey") apikey: String,
        @Query("oslc.where") wonum : String,
        @Query("oslc.select") select: String): Response<RisqueInter>


    @GET("os/PFEWA_INTER/?lean=1")
    suspend fun getPrecautionInter(
        @Query("apikey") apikey: String,
        @Query("oslc.where") wonum : String,
        @Query("oslc.select") select: String): Response<PcautionreInter>

}



