package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class MainDoeuvre(@SerializedName("member") val member : ArrayList<Assignment> )

data class Assignment (@SerializedName("assignment") val assignment : ArrayList<Assig> )

data class Assig(
    @SerializedName("laborhrs")
    val laborhrs : Double,

    @SerializedName("scheduledate")
    val scheduledate : String,

    @SerializedName("person")
    val person : ArrayList<Person>
)

data class Person(
    @SerializedName("displayname")
    val displayname : String,

    @SerializedName("personid")
    val personid : String
)