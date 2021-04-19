package com.example.talan_app.view_model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talan_app.model.Realisation

class RealisationVM: ViewModel {

    var arraylistmutablelivedata = MutableLiveData<ArrayList<RealisationVM>>()
    var arraylist = ArrayList<RealisationVM>()

    lateinit var context : Context
    var CodeRendu :String = ""
    var DescriptionRendu :String = ""
    var CodeEmploye : String = ""
    var DescriptionEmploye :String = ""
    var NbreHeur :String = ""
    var DateRealisation : String = ""

    constructor() : super()
    constructor(realisation: Realisation) : super() {
        this.CodeRendu = realisation.CodeRendu
        this.DescriptionRendu = realisation.DescriptionRendu
        this.CodeEmploye = realisation.CodeEmploye
        this.DescriptionEmploye = realisation.DescriptionEmploye
        this.NbreHeur = realisation.NbreHeur
        this.DateRealisation = realisation.DateRealisation
    }
    fun getArrayList() :MutableLiveData<ArrayList<RealisationVM>>{

        arraylist.add(RealisationVM(Realisation("1001","Fire Extinguisher xxz","1020",
                "1099","3","10/10/2021")))
        arraylist.add(RealisationVM(Realisation("1105","Fire Extinguisher xxz","1125",
                "1589","2","25/7/1999")))
        arraylist.add(RealisationVM(Realisation("2586","Fire Extinguisher xxz","5541",
                "1599","1","10/10/2019")))
        arraylist.add(RealisationVM(Realisation("1001","Fire Extinguisher xxz","1125",
                "1099","3","10/10/2021")))
        arraylist.add(RealisationVM(Realisation("1105","Fire Extinguisher xxz","1569",
                "1589","2","25/7/1999")))
        arraylist.add(RealisationVM(Realisation("2586","Fire Extinguisher xxz","1489",
                "1599","1","10/10/2019")))
        arraylist.add(RealisationVM(Realisation("1001","Fire Extinguisher xxz","1258",
                "1099","3","10/10/2021")))
        arraylist.add(RealisationVM(Realisation("1105","Fire Extinguisher xxz","1369",
                "1589","2","25/7/1999")))
        arraylist.add(RealisationVM(Realisation("2586","Fire Extinguisher xxz","7854",
                "1599","1","10/10/2019")))
        arraylist.add(RealisationVM(Realisation("1001","Fire Extinguisher xxz","1208",
                "1099","3","10/10/2021")))
        arraylist.add(RealisationVM(Realisation("1105","Fire Extinguisher xxz","1496",
                "1589","2","25/7/1999")))
        arraylist.add(RealisationVM(Realisation("2586","Fire Extinguisher xxz","1028",
                "1599","1","10/10/2019")))


        arraylistmutablelivedata.value = arraylist
        return arraylistmutablelivedata
    }
}

