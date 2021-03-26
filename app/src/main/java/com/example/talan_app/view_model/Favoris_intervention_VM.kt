package com.example.talan_app.view_model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talan_app.model.Intervention

class Favoris_intervention_VM: ViewModel {

    lateinit var context : Context
    var Code_Intervention :String? = null
    var Description_Intervention :String? = null
    var Etat_Intervention :String? = null
    var Code_actif :String? = null
    var Description_actif :String? = null
    var type_inter :String? = null
    var Priorite :String? = null
    var actif_date :String? = null

    constructor():super()
    constructor(intervention : Intervention) {
        this.Code_Intervention = intervention.Code_Intervention
        this.Description_Intervention = intervention.Description_Intervention
        this.Etat_Intervention = intervention.Etat_Intervention
        this.Code_actif = intervention.Code_actif
        this.Description_actif = intervention.Description_actif
        this.type_inter = intervention.type_inter
        this.Priorite = intervention.Priorite
        this.actif_date = intervention.actif_date
    }


    var arraylistmutablelivedata = MutableLiveData<ArrayList<Favoris_intervention_VM>>()
    var arraylist = ArrayList<Favoris_intervention_VM>()

    fun getArrayList() : MutableLiveData<ArrayList<Favoris_intervention_VM>> {

        arraylist.add(Favoris_intervention_VM(
            Intervention("1001","Fire Extinguisher xxz","ACTIVE",
            "1099","Fire OUI Extinguisher ","native","3","10/10/2021")
        ))
        arraylist.add(Favoris_intervention_VM(
            Intervention("1105","Fire Extinguisher xxz","ACTIVE",
            "1589","Fire OUI Extinguisher ","hybride","2","25/7/1999")
        ))
        arraylist.add(Favoris_intervention_VM(
            Intervention("2586","Fire Extinguisher xxz","ACTIVE",
            "1599","Fire OUI Extinguisher ","native","1","10/10/2019")
        ))
        arraylist.add(Favoris_intervention_VM(
            Intervention("1001","Fire Extinguisher xxz","ACTIVE",
            "1099","Fire OUI Extinguisher ","native","3","10/10/2021")
        ))
        arraylist.add(Favoris_intervention_VM(
            Intervention("1105","Fire Extinguisher xxz","ACTIVE",
            "1589","Fire OUI Extinguisher ","hybride","2","25/7/1999")
        ))
        arraylist.add(Favoris_intervention_VM(
            Intervention("2586","Fire Extinguisher xxz","ACTIVE",
            "1599","Fire OUI Extinguisher ","native","1","10/10/2019")
        ))
        arraylist.add(Favoris_intervention_VM(
            Intervention("1001","Fire Extinguisher xxz","ACTIVE",
            "1099","Fire OUI Extinguisher ","native","3","10/10/2021")
        ))
        arraylist.add(Favoris_intervention_VM(
            Intervention("1105","Fire Extinguisher xxz","ACTIVE",
            "1589","Fire OUI Extinguisher ","hybride","2","25/7/1999")
        ))



        arraylistmutablelivedata.value = arraylist
        return arraylistmutablelivedata
    }

}