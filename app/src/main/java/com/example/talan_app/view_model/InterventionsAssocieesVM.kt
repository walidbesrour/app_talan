package com.example.talan_app.view_model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talan_app.model.Intervention

class InterventionsAssocieesVM : ViewModel {


    lateinit var context : Context
    var Code_Intervention :String? = null
    var Description_Intervention :String? = null
    var Etat_Intervention :String? = null


    constructor():super()
    constructor(intervention : Intervention) {
        this.Code_Intervention = intervention.Code_Intervention
        this.Description_Intervention = intervention.Description_Intervention
        this.Etat_Intervention = intervention.Etat_Intervention

    }


    var arraylistmutablelivedata = MutableLiveData<ArrayList<InterventionsAssocieesVM>>()
    var arraylist = ArrayList<InterventionsAssocieesVM>()

    fun getArrayList() : MutableLiveData<ArrayList<InterventionsAssocieesVM>> {

        arraylist.add(InterventionsAssocieesVM(Intervention("1001","Etat_Intervention","ACTIVE")))
        arraylist.add(InterventionsAssocieesVM(Intervention("1105","l’European Union","ACTIVE")))
        arraylist.add(InterventionsAssocieesVM(Intervention("2586","Institute for Security ","ACTIVE")))
        arraylist.add(InterventionsAssocieesVM(Intervention("1001","Invitée : Alice Ekman","ACTIVE")))
        arraylist.add(InterventionsAssocieesVM(Intervention("1105","analyste responsable de l’Asie","ACTIVE")))
        arraylist.add(InterventionsAssocieesVM(Intervention("2586","Union Institute ","ACTIVE")))
        arraylist.add(InterventionsAssocieesVM(Intervention("1001","Fire Extinguisher xxz","ACTIVE")))
        arraylist.add(InterventionsAssocieesVM(Intervention("1105","la société chinoise","ACTIVE")))
        arraylist.add(InterventionsAssocieesVM(Intervention("2586","Institute for Security","ACTIVE")))
        arraylist.add(InterventionsAssocieesVM(Intervention("1001"," leur contras on en parle pas","ACTIVE")))
        arraylist.add(InterventionsAssocieesVM(Intervention("1105"," Xi Jinping rentrera","ACTIVE")))
        arraylist.add(InterventionsAssocieesVM(Intervention("2586","dans les livres","ACTIVE")))


        arraylistmutablelivedata.value = arraylist
        return arraylistmutablelivedata
    }


}