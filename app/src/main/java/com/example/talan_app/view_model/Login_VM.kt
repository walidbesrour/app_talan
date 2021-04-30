package com.example.talan_app.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.talan_app.model.Apikey
import com.example.talan_app.repository.RetrofitRepository
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import retrofit2.Response

class Login_VM (private val repository: RetrofitRepository): ViewModel(){

    var myResponse: MutableLiveData<Response<Apikey>> = MutableLiveData()

    fun getloginAPI(expiration: RequestBody,base64: String){
        viewModelScope.launch {

            val response = repository.getlogin(expiration,base64)
            myResponse.value = response
        }
    }
}