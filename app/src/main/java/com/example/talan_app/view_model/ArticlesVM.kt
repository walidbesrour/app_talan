package com.example.talan_app.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talan_app.model.Articles


class ArticlesVM : ViewModel {

    var arraylistmutablelivedata = MutableLiveData<ArrayList<ArticlesVM>>()
    var arraylist = ArrayList<ArticlesVM>()

    var CodeArticles : String = ""
    var DescriptionArticles :  String = ""
    var QuantiteArticles : String = ""
    var UniteArticles : String = ""


    constructor() : super()

    constructor(articles: Articles) : super() {
        this.CodeArticles = articles.CodeArticles
        this.DescriptionArticles = articles.DescriptionArticles
        this.QuantiteArticles = articles.QuantiteArticles
        this.UniteArticles = articles.UniteArticles
    }

    fun getArrayList() :MutableLiveData<ArrayList<ArticlesVM>>{

        arraylist.add(ArticlesVM(Articles("1001","Fire Extinguisher xxz","10", "109")))

        arraylist.add(ArticlesVM(Articles("1011","Fire Extinguisher xxz","25", "199")))

        arraylist.add(ArticlesVM(Articles("1025","Fire Extinguisher xxz","52", "2569")))

        arraylist.add(ArticlesVM(Articles("2558","Fire Extinguisher xxz","25", "368")))

        arraylist.add(ArticlesVM(Articles("1801","Fire Extinguisher xxz","52", "133")))

        arraylist.add(ArticlesVM(Articles("2685","Fire Extinguisher xxz","14", "699")))

        arraylist.add(ArticlesVM(Articles("1001","Fire Extinguisher xxz","100", "199")))

        arraylist.add(ArticlesVM(Articles("1026","Fire Extinguisher xxz","57", "199")))

        arraylist.add(ArticlesVM(Articles("8810","Fire Extinguisher xxz","69", "269")))




        arraylistmutablelivedata.value = arraylist
        return arraylistmutablelivedata
    }
}
