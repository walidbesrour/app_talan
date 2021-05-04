package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

class Actif {

    var Code =""
    var Description=""
    var Code_emplacement=""
    var children : Boolean = true

    constructor(Code: String, Description: String, Code_emplacement: String, children: Boolean) {
        this.Code = Code
        this.Description = Description
        this.Code_emplacement = Code_emplacement
        this.children = children
    }

    data class NamberActif (
            @SerializedName("member")
            val member : ArrayList<ActifsList> )
    data class ActifsList(
            val assetnum : String ,
            val description : String,
            val siteid : String,
            val parent : String,
            val children : Boolean ,
    )


}