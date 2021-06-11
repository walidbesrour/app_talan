package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class PieceJoint (@SerializedName("member") val member : ArrayList<doclinks>)
data class doclinks (@SerializedName("doclinks") val doclinks : Pisssse)
data class Pisssse (@SerializedName("member") val member : ArrayList<Pis>)
data class Pis (@SerializedName("describedBy") val describedBy : DescribedBy)
data class DescribedBy(

    @SerializedName("title")
    val title : String ,
    @SerializedName("description")
    val description : String ,
    @SerializedName("docType")
    val docType : String ,
    @SerializedName("fileName")
    val fileName : String
)