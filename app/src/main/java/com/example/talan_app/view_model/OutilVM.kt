package com.example.talan_app.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talan_app.model.MainDoeuvre
import com.example.talan_app.model.Outil

class OutilVM: ViewModel {


    var arraylistmutablelivedata = MutableLiveData<ArrayList<OutilVM>>()
    var arraylist = ArrayList<OutilVM>()

    var CodeOutil:String? = null
    var OutilDescription :String? = null

    constructor() : super()
    constructor(outil: Outil) : super() {
        this.CodeOutil = outil.CodeOutil
        this.OutilDescription = outil.OutilDescription
    }

    fun getArrayList() : MutableLiveData<ArrayList<OutilVM>> {

        arraylist.add(OutilVM(Outil("1001","Etat_Intervention")))
        arraylist.add(OutilVM(Outil("1105","l’European Union")))
        arraylist.add(OutilVM(Outil("2586","Institute for Security ")))
        arraylist.add(OutilVM(Outil("1001","Invitée : Alice Ekman")))
        arraylist.add(OutilVM(Outil("1105","analyste responsable de l’Asie")))
        arraylist.add(OutilVM(Outil("2586","Union Institute ")))
        arraylist.add(OutilVM(Outil("1001","Fire Extinguisher xxz")))
        arraylist.add(OutilVM(Outil("1105","la société chinoise")))
        arraylist.add(OutilVM(Outil("2586","Institute for Security")))
        arraylist.add(OutilVM(Outil("1001"," leur contras on en parle pas")))
        arraylist.add(OutilVM(Outil("1105"," Xi Jinping rentrera")))
        arraylist.add(OutilVM(Outil("2586","dans les livres")))


        arraylistmutablelivedata.value = arraylist
        return arraylistmutablelivedata
    }
}
