package com.example.talan_app.model

class Services {

    var Code_service =""
    var Description_service =""
    var Consigne_service=""
    var Etat_service =""
    var Code_actif =""
    var Description_actif =""

    constructor(Code_service: String, Description_service: String, Consigne_service: String, Etat_service: String, Code_actif: String, Description_actif: String) {
        this.Code_service = Code_service
        this.Description_service = Description_service
        this.Consigne_service = Consigne_service
        this.Etat_service = Etat_service
        this.Code_actif = Code_actif
        this.Description_actif = Description_actif
    }


}