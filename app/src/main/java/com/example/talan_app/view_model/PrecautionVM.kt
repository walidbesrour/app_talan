package com.example.talan_app.view_model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talan_app.model.Precaution


class PrecautionVM : ViewModel {

    var arraylistmutablelivedata = MutableLiveData<ArrayList<PrecautionVM>>()
    var arraylist = ArrayList<PrecautionVM>()

    var arraylistmutablelivedataInterv = MutableLiveData<ArrayList<PrecautionVM>>()
    var arraylistInterv = ArrayList<PrecautionVM>()

    lateinit var context : Context
    var Code_precaution  :String = ""
    var Description_precaution  :String = ""


    constructor(precaution: Precaution) : super() {
        this.Code_precaution = precaution.Code_precaution
        this.Description_precaution = precaution.Description_precaution
    }

    constructor() : super()


    fun getArrayList() :MutableLiveData<ArrayList<PrecautionVM>>{

        arraylist.add(PrecautionVM(Precaution("1001","Fire Extinguisher xxz")))
        arraylist.add(PrecautionVM(Precaution("1002","Extinguisher xxz")))
        arraylist.add(PrecautionVM(Precaution("1003","Fire xxz")))
        arraylist.add(PrecautionVM(Precaution("1004","Fire xxz")))
        arraylist.add(PrecautionVM(Precaution("1005","walid Extinguisher")))
        arraylist.add(PrecautionVM(Precaution("1006","Fire besrour")))
        arraylist.add(PrecautionVM(Precaution("1007","Fire xxz")))
        arraylist.add(PrecautionVM(Precaution("1008","walid Extinguisher")))
        arraylist.add(PrecautionVM(Precaution("1009","Fire besrour")))

        arraylistmutablelivedata.value = arraylist
        return arraylistmutablelivedata
    }

    fun getArrayListInterv() :MutableLiveData<ArrayList<PrecautionVM>>{

        arraylistInterv.add(PrecautionVM(Precaution("1001","Fire Extinguisher xxz")))
        arraylistInterv.add(PrecautionVM(Precaution("1002","Extinguisher xxz")))
        arraylistInterv.add(PrecautionVM(Precaution("1003","Fire xxz")))
        arraylistInterv.add(PrecautionVM(Precaution("1004","Fire xxz")))
        arraylistInterv.add(PrecautionVM(Precaution("1005","walid Extinguisher")))
        arraylistInterv.add(PrecautionVM(Precaution("1006","Fire besrour")))
        arraylistInterv.add(PrecautionVM(Precaution("1007","Fire xxz")))
        arraylistInterv.add(PrecautionVM(Precaution("1008","walid Extinguisher")))
        arraylistInterv.add(PrecautionVM(Precaution("1009","Fire besrour")))

        arraylistmutablelivedataInterv.value = arraylistInterv
        return arraylistmutablelivedataInterv
    }
}