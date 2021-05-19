package com.example.talan_app.view_model


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.talan_app.model.Precaution
import com.example.talan_app.repository.RetrofitRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class PrecautionVM (private val repository: RetrofitRepository): ViewModel(){

    var myResponse : MutableLiveData<Response<Precaution>> = MutableLiveData()


    fun getPrecautionActif(apikey: String,ASSETNUM: String ,Myselect: String){
        viewModelScope.launch {

            val response = repository.getPrecautionActif(apikey,ASSETNUM,Myselect)
            myResponse.value =  response
        }
    }

}