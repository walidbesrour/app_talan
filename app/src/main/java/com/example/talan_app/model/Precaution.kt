package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

class Precaution (@SerializedName("member") val member : ArrayList<LesPrecaution> )
data class LesPrecaution( @SerializedName("safetylexicon") val safetylexicon : ArrayList<MyPrecaution>)
data class MyPrecaution( @SerializedName("hazardprec") val hazardprec : ArrayList<Hazardprec>)
data class Hazardprec(
    @SerializedName("precautionid")
    val precautionid : String ,
    @SerializedName("precaution")
    val precaution : ArrayList<PrecautionDesc>
)
data class PrecautionDesc(
    @SerializedName("description")
    val description : String
)




