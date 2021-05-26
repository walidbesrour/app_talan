package com.example.talan_app.view_model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.talan_app.model.Journal
import com.example.talan_app.model.Services
import com.example.talan_app.repository.RetrofitRepositoryService
import kotlinx.coroutines.launch
import retrofit2.Response

class JournalVM (private val repository: RetrofitRepositoryService): ViewModel() {

    var myResponse : MutableLiveData<Response<Journal>> = MutableLiveData()


    fun getServiceJournal(apikey: String,ASSETNUM: String ,Myselect: String){
        viewModelScope.launch {

            val response = repository.getServiceJournal(apikey,ASSETNUM,Myselect)
            myResponse.value = response
        }
    }
}
