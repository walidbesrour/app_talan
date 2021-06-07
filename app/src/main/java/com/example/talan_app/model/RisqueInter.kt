package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class RisqueInter (@SerializedName("member") val member : ArrayList<Wosafetylink>)

data class Wosafetylink (@SerializedName("wosafetylink") val wosafetylink : ArrayList<Wosaf>)

data class Wosaf(

    @SerializedName("hazardid")
    val hazardid : String,

    @SerializedName("hazarddescription")
    val hazarddescription : String,


)