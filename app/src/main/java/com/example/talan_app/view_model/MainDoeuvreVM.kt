package com.example.talan_app.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talan_app.model.MainDoeuvre

class MainDoeuvreVM: ViewModel {


    var arraylistmutablelivedata = MutableLiveData<ArrayList<MainDoeuvreVM>>()
    var arraylist = ArrayList<MainDoeuvreVM>()

    var CodeEmploye:String? = null
    var CodeDescription :String? = null

    constructor() : super()
    constructor(mainDoeuvre: MainDoeuvre) : super() {
        this.CodeEmploye = mainDoeuvre.CodeEmploye
        this.CodeDescription = mainDoeuvre.CodeDescription
    }

    fun getArrayList() : MutableLiveData<ArrayList<MainDoeuvreVM>> {

        arraylist.add(MainDoeuvreVM(MainDoeuvre("1001","Etat_Intervention")))
        arraylist.add(MainDoeuvreVM(MainDoeuvre("1105","l’European Union")))
        arraylist.add(MainDoeuvreVM(MainDoeuvre("2586","Institute for Security ")))
        arraylist.add(MainDoeuvreVM(MainDoeuvre("1001","Invitée : Alice Ekman")))
        arraylist.add(MainDoeuvreVM(MainDoeuvre("1105","analyste responsable de l’Asie")))
        arraylist.add(MainDoeuvreVM(MainDoeuvre("2586","Union Institute ")))
        arraylist.add(MainDoeuvreVM(MainDoeuvre("1001","Fire Extinguisher xxz")))
        arraylist.add(MainDoeuvreVM(MainDoeuvre("1105","la société chinoise")))
        arraylist.add(MainDoeuvreVM(MainDoeuvre("2586","Institute for Security")))
        arraylist.add(MainDoeuvreVM(MainDoeuvre("1001"," leur contras on en parle pas")))
        arraylist.add(MainDoeuvreVM(MainDoeuvre("1105"," Xi Jinping rentrera")))
        arraylist.add(MainDoeuvreVM(MainDoeuvre("2586","dans les livres")))


        arraylistmutablelivedata.value = arraylist
        return arraylistmutablelivedata
    }
}
