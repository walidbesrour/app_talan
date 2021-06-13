package com.example.talan_app.model

import com.google.gson.annotations.SerializedName

data class Actifs (@SerializedName("member") val member : ArrayList<ActifsListmember> )
data class ActifsListmember(
        // 1
        val assetnum : String ,
        // 2
        val description : String,
        // 3 status
        val status : String ,
        // 4 site ( ajouter au detail)
        val siteid : String,
        // 5
        val parent : String,

        // emplacement

        @SerializedName("locations")
        val locations : ArrayList<Mylocation> ,

        // 9 numéro de série
        val serialnum : String ,

        // information adresse
        @SerializedName("serviceaddress")
        val serviceaddress : ArrayList<serviceaddress> ,

        val children : Boolean ,

        @SerializedName("description_longdescription")
        val description_longdescription : String ,

        @SerializedName("workorder")
        val workorder : ArrayList<Workorder>,

        @SerializedName("_imagelibref")
        val _imagelibref : String


)
data class Mylocation (
        // 6
        val location : String,
        // 7
        val description : String,
        // 8
        val status : String
)
data class serviceaddress(
        // 10 adresse service
        val addresscode : String,
        // 11
        val county : String,
        // 12 ville
        val formattedaddress : String,
        // 13 rue
        val regiondistrict : String
)
data class Workorder(

        @SerializedName("wonum")
        val wonum : String,
        @SerializedName("description")
        val description : String,
        @SerializedName("status")
        val status : String
)
