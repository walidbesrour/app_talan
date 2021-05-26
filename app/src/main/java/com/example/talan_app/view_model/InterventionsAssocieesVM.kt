package com.example.talan_app.view_model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.talan_app.model.Actifs
import com.example.talan_app.model.Intervention
import com.example.talan_app.repository.RetrofitRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class InterventionsAssocieesVM (private val repository: RetrofitRepository): ViewModel() {

    var myResponseDetailInterv : MutableLiveData<Response<Actifs>> = MutableLiveData()

    fun getDetailInterv(apikey: String,ASSETNUM: String ,Myselect: String){
        viewModelScope.launch {
            val response1 = repository.getDetailInterv(apikey,ASSETNUM,Myselect)
            myResponseDetailInterv.value = response1
        }
    }
}