package com.example.talan_app.model

class Intervention {

     var Code_Intervention :String? = null
    var Description_Intervention :String? = null
    var Etat_Intervention :String? = null
    var Code_actif :String? = null
    var Description_actif :String? = null
    var type_inter :String? = null
    var Priorite :String? = null
    var actif_date :String? = null

    constructor(Code_Intervention: String?, Description_Intervention: String?, Etat_Intervention: String?, Code_actif: String?, Description_actif: String?, type_inter: String?, Priorite: String?, actif_date: String?) {
        this.Code_Intervention = Code_Intervention
        this.Description_Intervention = Description_Intervention
        this.Etat_Intervention = Etat_Intervention
        this.Code_actif = Code_actif
        this.Description_actif = Description_actif
        this.type_inter = type_inter
        this.Priorite = Priorite
        this.actif_date = actif_date
    }
}

