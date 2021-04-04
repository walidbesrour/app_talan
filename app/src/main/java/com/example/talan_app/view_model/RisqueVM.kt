package com.example.talan_app.view_model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talan_app.model.Risque

class RisqueVM : ViewModel {
    lateinit var context : Context
    var Code_risque :String = ""
    var Description_risque :String = ""

    var arraylistmutablelivedata = MutableLiveData<ArrayList<RisqueVM>>()
    var arraylist = ArrayList<RisqueVM>()


    constructor(risque: Risque) : super() {
        this.Code_risque = risque.Code_risque
        this.Description_risque = risque.Description_risque
    }

    constructor() : super()

    fun getArrayList() :MutableLiveData<ArrayList<RisqueVM>>{

        arraylist.add(RisqueVM(Risque("1001","Fire Extinguisher xxz")))
        arraylist.add(RisqueVM(Risque("1002","Extinguisher xxz")))
        arraylist.add(RisqueVM(Risque("1003","Fire xxz")))
        arraylist.add(RisqueVM(Risque("1004","Fire xxz")))
        arraylist.add(RisqueVM(Risque("1005","walid Extinguisher")))
        arraylist.add(RisqueVM(Risque("1006","Fire besrour")))
        arraylist.add(RisqueVM(Risque("1007","Fire xxz")))
        arraylist.add(RisqueVM(Risque("1008","walid Extinguisher")))
        arraylist.add(RisqueVM(Risque("1009","Fire besrour")))

        arraylistmutablelivedata.value = arraylist
        return arraylistmutablelivedata
    }

}