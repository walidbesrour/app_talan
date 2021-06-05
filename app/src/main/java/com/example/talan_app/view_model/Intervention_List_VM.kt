package com.example.talan_app.view_model


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.talan_app.model.Intervention

import com.example.talan_app.repository.RetrofitRepositoryIntervention
import kotlinx.coroutines.launch
import retrofit2.Response


class Intervention_List_VM (private val repository: RetrofitRepositoryIntervention): ViewModel() {

    var myResponse  : MutableLiveData<Response<Intervention>> = MutableLiveData()
    var myResponse1  : MutableLiveData<Response<Intervention>> = MutableLiveData()

    var ResponseFavoris  : MutableLiveData<Response<Intervention>> = MutableLiveData()
    var ResponseInter  : MutableLiveData<Response<Intervention>> = MutableLiveData()

    var ResponseFILS  : MutableLiveData<Response<Intervention>> = MutableLiveData()



    fun getListIntervention(apikey: String,select: String,pageSize: Int,pageno: Int){
        viewModelScope.launch {

            val response = repository.getListIntervention(apikey,select,pageSize,pageno)
            myResponse.value = response
        }
    }

    fun getListIntervention1(apikey: String,select: String,pageSize: Int,pageno: Int){
        viewModelScope.launch {

            val response = repository.getListIntervention(apikey,select,pageSize,pageno)
            myResponse1.value = response
        }
    }

    fun getListInterventionFavoris(apikey: String,select: String,bookmark: String){
        viewModelScope.launch {

            val response = repository.getListInterventionFavoris(apikey,select,bookmark)
            ResponseFavoris.value = response
        }
    }


    fun getDetailFavoris(apikey: String,wonum: String,select: String){
        viewModelScope.launch {
            val response = repository.getDetailFavoris(apikey,wonum,select)
            ResponseInter.value = response
        }
    }

    fun getFilsFavoris(apikey: String,select: String,wonum: String){
        viewModelScope.launch {
            val response = repository.getFilsFavoris(apikey,select,wonum)
            ResponseFILS.value = response
        }
    }


}