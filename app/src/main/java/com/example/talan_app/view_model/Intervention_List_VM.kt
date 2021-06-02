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



    fun getListIntervention(apikey: String,select: String,pageSize: Int,pageno: Int){
        viewModelScope.launch {

            val response = repository.getListIntervention(apikey,select,pageSize,pageno)
            myResponse.value = response
        }
    }


}