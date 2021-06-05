package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class Intervention (@SerializedName("member") val member : ArrayList<Inter> )
data class Inter(

    @SerializedName("wonum")
    val wonum : String ,

    @SerializedName("description")
    val description : String,

    @SerializedName("status")
    val status : String ,

    @SerializedName("siteid")
    val siteid : String,

    @SerializedName("asset")
    val asset : ArrayList<Asset>,

    @SerializedName("worktype")
    val worktype : String ,


    @SerializedName("wogroup")
    val wogroup : String ,


    @SerializedName("parent")
    val parent : String,

    @SerializedName("wopriority")
    val wopriority : Int,

    @SerializedName("location")
    val location : String ,

    @SerializedName("targstartdate")
    val targstartdate : String,

    @SerializedName("bookmark")
    val bookmark : ArrayList<Bookmark>

)

data class Bookmark(
    @SerializedName("keyvalue")
    val keyvalue : Int ,

    @SerializedName("userid")
    val userid : String ,

    @SerializedName("app")
    val app : String
)

data class Asset(
    @SerializedName("assetnum")
    val assetnum : String ,

    @SerializedName("description")
    val description : String
)

