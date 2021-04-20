package com.example.talan_app.view_model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.talan_app.model.Tache

class TacheVM: ViewModel {

    lateinit var context : Context
    var arraylistmutablelivedata = MutableLiveData<ArrayList<TacheVM>>()
    var arraylist = ArrayList<TacheVM>()


    var CodeTache =""
    var DescriptionTache =""
    var DureeTache=""


    constructor() : super()
    constructor(tache : Tache): super() {
        this.CodeTache = tache.CodeTache
        this.DescriptionTache = tache.DescriptionTache
        this.DureeTache = tache.DureeTache
    }

    fun getArrayList() :MutableLiveData<ArrayList<TacheVM>>{

        arraylist.add(TacheVM(Tache("1001","Fire Extinguisher xxz","020", )))
        arraylist.add(TacheVM(Tache("1105","Fire Extinguisher xxz","125", )))
        arraylist.add(TacheVM(Tache("2586","Fire Extinguisher xxz","541", )))
        arraylist.add(TacheVM(Tache("1001","Fire Extinguisher xxz","125", )))
        arraylist.add(TacheVM(Tache("1105","Fire Extinguisher xxz","569", )))
        arraylist.add(TacheVM(Tache("2586","Fire Extinguisher xxz","189", )))
        arraylist.add(TacheVM(Tache("1001","Fire Extinguisher xxz","158", )))
        arraylist.add(TacheVM(Tache("1105","Fire Extinguisher xxz","139", )))
        arraylist.add(TacheVM(Tache("2586","Fire Extinguisher xxz","754", )))
        arraylist.add(TacheVM(Tache("1001","Fire Extinguisher xxz","108", )))
        arraylist.add(TacheVM(Tache("1105","Fire Extinguisher xxz","196", )))
        arraylist.add(TacheVM(Tache("2586","Fire Extinguisher xxz","102", )))

        arraylistmutablelivedata.value = arraylist
        return arraylistmutablelivedata
    }
}
