package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class ServicesPlan (@SerializedName("member") val member : ArrayList<Wpservice>)

data class Wpservice(@SerializedName("wpservice") val wpservice : ArrayList<Serv>)

data class Serv(

    @SerializedName("itemnum")
    val itemnum : String,

    @SerializedName("description")
    val description : String,

    @SerializedName("itemqty")
    val itemqty : Double,

    @SerializedName("unitcost")
    val unitcost : Double
)