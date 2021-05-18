package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class Compteurs(@SerializedName("member") val member : ArrayList<AssetM> )

data class AssetM( @SerializedName("assetmeter") val assetmeter : ArrayList<Assetmeter>)

data class Assetmeter(
    @SerializedName("_rowstamp")
    val rowstamp : String ,
    @SerializedName("lastreadingdate")
    val lastreadingdate : String ,

    @SerializedName("meter")
    val meter : ArrayList<Meter>
)
data class Meter(val description : String)
