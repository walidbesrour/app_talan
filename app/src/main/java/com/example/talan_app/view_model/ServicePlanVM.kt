package com.example.talan_app.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talan_app.model.Articles
import com.example.talan_app.model.ServicesPlan


class ServicePlanVM : ViewModel {

    var arraylistmutablelivedata = MutableLiveData<ArrayList<ServicePlanVM>>()
    var arraylist = ArrayList<ServicePlanVM>()

    var CodeArticles : String = ""
    var DescriptionArticles :  String = ""
    var QuantiteArticles : String = ""
    var UniteArticles : String = ""


    constructor() : super()

    constructor(servicesPlan: ServicesPlan) : super() {
        this.CodeArticles = servicesPlan.CodeArticles
        this.DescriptionArticles = servicesPlan.DescriptionArticles
        this.QuantiteArticles = servicesPlan.QuantiteArticles
        this.UniteArticles = servicesPlan.UniteArticles
    }

    fun getArrayList() :MutableLiveData<ArrayList<ServicePlanVM>>{

        arraylist.add(ServicePlanVM(ServicesPlan("1001","Fire Extinguisher xxz","10", "109")))

        arraylist.add(ServicePlanVM(ServicesPlan("1011","Fire Extinguisher xxz","25", "199")))

        arraylist.add(ServicePlanVM(ServicesPlan("1025","Fire Extinguisher xxz","52", "2569")))

        arraylist.add(ServicePlanVM(ServicesPlan("2558","Fire Extinguisher xxz","25", "368")))

        arraylist.add(ServicePlanVM(ServicesPlan("1801","Fire Extinguisher xxz","52", "133")))

        arraylist.add(ServicePlanVM(ServicesPlan("2685","Fire Extinguisher xxz","14", "699")))

        arraylist.add(ServicePlanVM(ServicesPlan("1001","Fire Extinguisher xxz","100", "199")))

        arraylist.add(ServicePlanVM(ServicesPlan("1026","Fire Extinguisher xxz","57", "199")))

        arraylist.add(ServicePlanVM(ServicesPlan("8810","Fire Extinguisher xxz","69", "269")))




        arraylistmutablelivedata.value = arraylist
        return arraylistmutablelivedata
    }
}
