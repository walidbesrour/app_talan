package com.example.talan_app.view_model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talan_app.model.Services

class Service_List_VM : ViewModel {
    lateinit var context : Context
    var Code_service =""
    var Description_service =""
    var Consigne_service=""
    var Etat_service =""
    var Code_actif =""
    var Description_actif =""



        var arraylistmutablelivedata = MutableLiveData<ArrayList<Service_List_VM>>()
        var arraylist = ArrayList<Service_List_VM>()


    constructor() : super()

    constructor(services: Services) : super() {
        this.Code_service = services.Code_service
        this.Description_service = services.Description_service
        this.Consigne_service = services.Consigne_service
        this.Etat_service = services.Etat_service
        this.Code_actif = services.Code_actif
        this.Description_actif = services.Description_actif
    }



    fun getArrayList() :MutableLiveData<ArrayList<Service_List_VM>>{

        arraylist.add(Service_List_VM(Services("1001","Fire Extinguisher xxz","CENTRAL1",
                "1099","Fire Extinguisher ","Fire Extinguisher xxz")))

        arraylist.add(Service_List_VM(Services("1011","Fire Extinguisher xxz","CENTRAL1",
                "1599","Fire Extinguisher ","Fire Extinguisher xxz")))

        arraylist.add(Service_List_VM(Services("1025","Fire Extinguisher xxz","CENTRAL1",
                "2569","Fire Extinguisher ","Actif Fire Extinguisher xxz")))

        arraylist.add(Service_List_VM(Services("2558","Fire Extinguisher xxz","CENTRAL1",
                "368","Fire Extinguisher ","Actif")))

        arraylist.add(Service_List_VM(Services("1801","Fire Extinguisher xxz","CENTRAL1",
                "1033","Fire Extinguisher ","Actif")))

        arraylist.add(Service_List_VM(Services("2685","Fire Extinguisher xxz","CENTRAL1",
                "6699","Fire Extinguisher ","Actif")))
        arraylist.add(Service_List_VM(Services("1001","Fire Extinguisher xxz","CENTRAL1",
                "1599","Fire Extinguisher ","Fire Extinguisher xxz Actif")))

        arraylist.add(Service_List_VM(Services("1026","Fire Extinguisher xxz","CENTRAL1",
                "1999","Fire Extinguisher ","Fire Extinguisher xxz Actif")))

        arraylist.add(Service_List_VM(Services("8810","Fire Extinguisher xxz","CENTRAL1",
                "2369","Fire Extinguisher ","ActFire Extinguisher xxzif")))




        arraylistmutablelivedata.value = arraylist
        return arraylistmutablelivedata
    }

}