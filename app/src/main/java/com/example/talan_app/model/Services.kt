package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class Services (@SerializedName("member") val member : ArrayList<ServiceList>)
data class ServiceList(

    @SerializedName("ticketid")
    val ticketid : String ,
    @SerializedName("description")
    val description : String ,
    @SerializedName("reportedby")
    val reportedby : String ,
    @SerializedName("status")
    val status : String ,
    @SerializedName("siteid")
    val siteid : String ,
    @SerializedName("asset")
    val asset : ArrayList<AssetS>
)
data class AssetS(
    @SerializedName("assetnum")
    val assetnum : String ,
    @SerializedName("description")
    val description : String
)