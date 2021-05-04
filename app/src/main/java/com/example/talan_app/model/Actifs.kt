package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class Actifs (@SerializedName("member") val member : ArrayList<ActifsListmember> )
data class ActifsListmember(
        val assetnum : String ,
        val description : String,
        val siteid : String,
        val parent : String,
        val children : Boolean ,
)
