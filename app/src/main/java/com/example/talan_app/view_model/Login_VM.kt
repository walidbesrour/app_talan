package com.example.talan_app.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.talan_app.model.Expiration
import com.example.talan_app.repository.RetrofitRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class Login_VM (private val repository: RetrofitRepository): ViewModel(){

    var myResponse: MutableLiveData<Response<String>> = MutableLiveData()

    fun getloginAPI(expiration: Expiration){
        viewModelScope.launch {
            val response = repository.getlogin(expiration)
            myResponse.value = response
        }
    }
}