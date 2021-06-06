package com.example.talan_app.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.talan_app.model.Articles
import com.example.talan_app.model.MainDoeuvre
import com.example.talan_app.model.ServicesPlan
import com.example.talan_app.model.Tache
import com.example.talan_app.repository.RetrofitRepositoryIntervention
import kotlinx.coroutines.launch
import retrofit2.Response

class PlanInterVM (private val repository: RetrofitRepositoryIntervention): ViewModel(){

    var myResponseTache  : MutableLiveData<Response<Tache>> = MutableLiveData()
    var myResponseMain  : MutableLiveData<Response<MainDoeuvre>> = MutableLiveData()
    var myResponseArticle  : MutableLiveData<Response<Articles>> = MutableLiveData()
    var myResponseServ  : MutableLiveData<Response<ServicesPlan>> = MutableLiveData()


    fun getTacheInter(apikey: String,wonum: String,select: String){
        viewModelScope.launch {
            val response = repository.getTacheInter(apikey,wonum,select)
            myResponseTache.value = response
        }
    }


    fun getMainInter(apikey: String,wonum: String,select: String){
        viewModelScope.launch {
            val response = repository.getMainInter(apikey,wonum,select)
            myResponseMain.value = response
        }
    }

    fun getArticleInter(apikey: String,wonum: String,select: String){
        viewModelScope.launch {
            val response = repository.getArticleInter(apikey,wonum,select)
            myResponseArticle.value = response
        }
    }

    fun getServInter(apikey: String,wonum: String,select: String){
        viewModelScope.launch {
            val response = repository.getServInter(apikey,wonum,select)
            myResponseServ.value = response
        }
    }

}