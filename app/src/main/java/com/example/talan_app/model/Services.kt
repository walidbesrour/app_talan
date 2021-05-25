package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class Services (@SerializedName("member") val member : ArrayList<ServiceList>)
data class ServiceList(

    @SerializedName("ticketid")
    val ticketid : String ,
    @SerializedName("description")
    val description : String ,

    @SerializedName("status")
    val status : String ,
    @SerializedName("siteid")
    val siteid : String ,
    @SerializedName("asset")
    val asset : ArrayList<AssetS>,
    @SerializedName("locations")
    val locations : ArrayList<Location>,
    @SerializedName("tkserviceaddress")
    val address : ArrayList<Addresse>,
    @SerializedName("description_longdescription")
    val description_longdescription : String,


    @SerializedName("reportdate")
    val reportdate : String,
    @SerializedName("affecteddate")
    val affecteddate : String,
    @SerializedName("actualfinish")
    val actualfinish : String,



    ///////// affecter par
    @SerializedName("affectedperson")
    val affectedperson : String,
    @SerializedName("affectedphone")
    val affectedphone : String,
    @SerializedName("affectedemail")
    val affectedemail : String,

    ///////// consigné par
    @SerializedName("reportedby")
    val reportedby : String ,
    @SerializedName("reportedphone")
    val reportedphone : String,
    @SerializedName("reportedemail")
    val reportedemail : String


)
data class AssetS(
    @SerializedName("assetnum")
    val assetnum : String ,
    @SerializedName("description")
    val description : String
    )

data class Location(
    @SerializedName("location")
    val location : String ,
    @SerializedName("description")
    val description : String
)

data class Addresse(
    @SerializedName("addressline3")
    val addressline3 : String ,
    @SerializedName("regiondistrict")
    val regiondistrict : String,
    @SerializedName("city")
    val city : String ,
    @SerializedName("streetaddress")
    val streetaddress : String
)
