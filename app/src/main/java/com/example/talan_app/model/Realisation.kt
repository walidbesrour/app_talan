package com.example.talan_app.model

class Realisation {

    var CodeRendu :String = ""
    var DescriptionRendu :String = ""
    var CodeEmploye : String = ""
    var DescriptionEmploye :String = ""
    var NbreHeur :String = ""
    var DateRealisation : String = ""

    constructor(CodeRendu: String, DescriptionRendu: String, CodeEmploye: String, DescriptionEmploye: String, NbreHeur: String, DateRealisation: String) {
        this.CodeRendu = CodeRendu
        this.DescriptionRendu = DescriptionRendu
        this.CodeEmploye = CodeEmploye
        this.DescriptionEmploye = DescriptionEmploye
        this.NbreHeur = NbreHeur
        this.DateRealisation = DateRealisation
    }
}