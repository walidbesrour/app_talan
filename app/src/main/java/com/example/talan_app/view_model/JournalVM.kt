package com.example.talan_app.view_model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talan_app.model.Journal

class JournalVM  : ViewModel {
    lateinit var context : Context
    var n_journal :String = ""
    var datajournal :String = ""
    var typejournal : String = ""
    var creejournal : String = ""

       var arraylistmutablelivedata = MutableLiveData<ArrayList<JournalVM>>()
       var arraylist = ArrayList<JournalVM>()

    constructor(journal:Journal) {
        this.n_journal = journal.n_journal
        this.datajournal = journal.datajournal
        this.typejournal = journal.typejournal
        this.creejournal = journal.creejournal
    }

    constructor() : super()


    fun getArrayList() :MutableLiveData<ArrayList<JournalVM>>{

        arraylist.add(JournalVM(Journal("1001","10/10/2020","Fire Extinguisher xxz","walid besrour")))
        arraylist.add(JournalVM(Journal("1002","5/11/2020","Extinguisher xxz","sami")))
        arraylist.add(JournalVM(Journal("1003","16/10/2020","Fire xxz","besrour")))
        arraylist.add(JournalVM(Journal("1004","10/10/2020","Fire xxz","manuel")))
        arraylist.add(JournalVM(Journal("1005","20/10/2020","walid Extinguisher","luffy")))
        arraylist.add(JournalVM(Journal("1006","25/10/2020","Fire besrour","zoro")))
        arraylist.add(JournalVM(Journal("1007","6/10/2020","Fire xxz","sanji")))
        arraylist.add(JournalVM(Journal("1008","9/10/2020","walid Extinguisher","usop")))
        arraylist.add(JournalVM(Journal("1009","20/10/2020","Fire besrour","nami")))

        arraylistmutablelivedata.value = arraylist
        return arraylistmutablelivedata
    }

}
