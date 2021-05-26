package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class Journal(@SerializedName("member") val member : ArrayList<Worklogs> )

data class Worklogs(

    @SerializedName("worklog")
    val worklog : ArrayList<Journals> ,

)


data class Journals(
    @SerializedName("worklogid")
    val worklogid : String ,
    @SerializedName("createdate")
    val createdate : String ,
    @SerializedName("createby")
    val createby : String ,
    @SerializedName("description")
    val description : String
)