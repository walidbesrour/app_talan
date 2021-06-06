package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class Tache (@SerializedName("member") val member : ArrayList<InterTache> )

data class InterTache (@SerializedName("woactivity") val woactivity : ArrayList<Woactivity> )

data class Woactivity(

    @SerializedName("wosequence")
    val wosequence : Int ,

    @SerializedName("description")
    val description : String,

    @SerializedName("estdur")
    val estdur : Double
)

