package com.example.talan_app.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.talan_app.model.Tache
import com.example.talan_app.repository.RetrofitRepositoryIntervention
import kotlinx.coroutines.launch
import retrofit2.Response

class PlanInterVM (private val repository: RetrofitRepositoryIntervention): ViewModel(){

    var myResponseTache  : MutableLiveData<Response<Tache>> = MutableLiveData()


    fun getTacheInter(apikey: String,wonum: String,select: String){
        viewModelScope.launch {
            val response = repository.getTacheInter(apikey,wonum,select)
            myResponseTache.value = response
        }
    }


}