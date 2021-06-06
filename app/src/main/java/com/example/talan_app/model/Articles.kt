package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class Articles (@SerializedName("member") val member : ArrayList<Wpmaterial> )

data class Wpmaterial (@SerializedName("wpmaterial") val wpmaterial : ArrayList<Artic> )

data class Artic (

    @SerializedName("itemnum")
    val itemnum : String,

    @SerializedName("description")
    val description : String,

    @SerializedName("itemqty")
    val itemqty : Double,

    @SerializedName("unitcost")
    val unitcost : Double

    )