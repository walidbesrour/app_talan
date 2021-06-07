package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class Outil (@SerializedName("member") val member : ArrayList<Wptool>)

data class Wptool(@SerializedName("wptool") val wptool : ArrayList<OutilInter>)

data class OutilInter(

    @SerializedName("itemnum")
    val itemnum : String,

    @SerializedName("description")
    val description : String,


)