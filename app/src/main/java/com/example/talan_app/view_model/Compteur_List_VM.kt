package com.example.talan_app.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.talan_app.model.Compteurs
import com.example.talan_app.repository.RetrofitRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class Compteur_List_VM (private val repository: RetrofitRepository): ViewModel()  {


    var myResponse : MutableLiveData<Response<Compteurs>> = MutableLiveData()



    fun getCompteurActif(apikey: String,ASSETNUM: String ,Myselect: String){
        viewModelScope.launch {

            val response = repository.getCompteurActif(apikey,ASSETNUM,Myselect)
            myResponse.value = response
        }
    }
}