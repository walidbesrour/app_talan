package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class PcautionreInter (@SerializedName("member") val member : ArrayList<Wosafe>)

data class Wosafe (@SerializedName("wohazardprec") val wohazardprec : ArrayList<Wosa>)

data class Wosa(

    @SerializedName("precautionid")
    val precautionid : String,

    @SerializedName("description")
    val description : String,
)

