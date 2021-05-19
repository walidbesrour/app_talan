package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class PieceD (@SerializedName("member") val member : ArrayList<Sparepart>)
data class Sparepart(@SerializedName("sparepart") val sparepart : ArrayList<Piece>)
data class Piece(
    @SerializedName("itemnum")
    val itemnum : String ,
    @SerializedName("quantity")
    val quantity : Double,
    @SerializedName("description")
    val description : String ,
)