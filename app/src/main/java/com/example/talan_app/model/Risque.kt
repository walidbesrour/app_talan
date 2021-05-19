package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class Risque (@SerializedName("member") val member : ArrayList<LesRisque> )

data class LesRisque( @SerializedName("safetylexicon") val safetylexicon : ArrayList<MyRisque>)

data class MyRisque( @SerializedName("hazard") val hazard : ArrayList<Hazard>)

data class Hazard(
    @SerializedName("description")
    val description : String ,
    @SerializedName("hazardid")
    val hazardid : String ,

)

