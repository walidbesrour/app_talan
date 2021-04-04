package com.example.talan_app.view_model

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talan_app.MainActivity
import com.example.talan_app.detail.Actif_Detail
import com.example.talan_app.menu_fragments.ActifFragment
import com.example.talan_app.model.Actif


class FilsActif_List_VM : ViewModel {
lateinit var context : Context
    var Code1 =""
    var Description1 =""
    var Code_emplacement1 =""


    constructor(): super()
    constructor(actif: Actif) : super() {
        this.Code1 = actif.Code
        this.Description1 = actif.Description
        this.Code_emplacement1 = actif.Code_emplacement
    }

    var arraylistmutablelivedata = MutableLiveData<ArrayList<FilsActif_List_VM>>()

    var arraylist = ArrayList<FilsActif_List_VM>()


    fun getArrayList() :MutableLiveData<ArrayList<FilsActif_List_VM>>{

        arraylist.add(FilsActif_List_VM(Actif("1001","Fire Extinguisher xxz","CENTRAL1")))
        arraylist.add(FilsActif_List_VM(Actif("1002","Fire Extinguisher xxz","CENTRAL2")))
        arraylist.add(FilsActif_List_VM(Actif("1003","Fire Extinguisher xxz","CENTRAL3")))
        arraylist.add(FilsActif_List_VM(Actif("1004","Fire Extinguisher xxz","CENTRAL4")))
        arraylist.add(FilsActif_List_VM(Actif("1005","Fire Extinguisher xxz","CENTRAL5")))
        arraylist.add(FilsActif_List_VM(Actif("1006","Fire Extinguisher xxz","CENTRAL6")))
        arraylist.add(FilsActif_List_VM(Actif("1007","Fire Extinguisher xxz","CENTRAL7")))
        arraylist.add(FilsActif_List_VM(Actif("1008","Fire Extinguisher xxz","CENTRAL8")))
        arraylist.add(FilsActif_List_VM(Actif("1009","Fire Extinguisher xxz","CENTRAL9")))
        arraylist.add(FilsActif_List_VM(Actif("1010","Fire Extinguisher xxz","CENTRAL10")))
        arraylist.add(FilsActif_List_VM(Actif("1011","Fire Extinguisher xxz","CENTRAL11")))
        arraylist.add(FilsActif_List_VM(Actif("1012","Fire Extinguisher xxz","CENTRAL12")))


                arraylistmutablelivedata.value = arraylist
                return arraylistmutablelivedata
    }


}