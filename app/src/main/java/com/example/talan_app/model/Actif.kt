package com.example.talan_app.model

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
}