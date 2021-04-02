package com.example.talan_app.view_model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talan_app.model.Compteur
import com.example.talan_app.model.Services

class Compteur_List_VM : ViewModel {
    lateinit var context : Context
    var codecompteur :String = ""
    var descriptionDesc :String = ""
    var compteurDate : String = ""



    var arraylistmutablelivedata = MutableLiveData<ArrayList<Compteur_List_VM>>()
    var arraylist = ArrayList<Compteur_List_VM>()


    constructor(compteur :Compteur) : super() {
        this.codecompteur = compteur.codecompteur
        this.descriptionDesc = compteur.descriptionDesc
        this.compteurDate = compteur.compteurDate
    }

    constructor() : super()

    fun getArrayList() :MutableLiveData<ArrayList<Compteur_List_VM>>{

        arraylist.add(Compteur_List_VM(Compteur("1001","Fire Extinguisher xxz","10/10/2020")))
        arraylist.add(Compteur_List_VM(Compteur("1002","Extinguisher xxz","10/10/2020")))
        arraylist.add(Compteur_List_VM(Compteur("1003","Fire  xxz","10/10/2020")))
        arraylist.add(Compteur_List_VM(Compteur("1004","Extinguisher xxz","10/10/2020")))
        arraylist.add(Compteur_List_VM(Compteur("1005","Fire walid xxz","10/10/2020")))
        arraylist.add(Compteur_List_VM(Compteur("1006","besrour Extinguisher xxz","10/10/2020")))
        arraylist.add(Compteur_List_VM(Compteur("1001","Fire Extinguisher xxz","10/10/2020")))
        arraylist.add(Compteur_List_VM(Compteur("1002","Extinguisher xxz","10/10/2020")))
        arraylist.add(Compteur_List_VM(Compteur("1003","Fire  xxz","10/10/2020")))
        arraylist.add(Compteur_List_VM(Compteur("1004","Extinguisher xxz","10/10/2020")))
        arraylist.add(Compteur_List_VM(Compteur("1005","Fire walid xxz","10/10/2020")))
        arraylist.add(Compteur_List_VM(Compteur("1006","besrour Extinguisher xxz","10/10/2020")))


        arraylistmutablelivedata.value = arraylist
        return arraylistmutablelivedata
    }
}