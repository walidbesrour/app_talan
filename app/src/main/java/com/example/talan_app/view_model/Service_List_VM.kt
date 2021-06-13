package com.example.talan_app.view_model


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.talan_app.model.Services


import com.example.talan_app.repository.RetrofitRepositoryService
import kotlinx.coroutines.launch
import retrofit2.Response

class Service_List_VM (private val repository: RetrofitRepositoryService): ViewModel() {

    var myResponse : MutableLiveData<Response<Services>> = MutableLiveData()
    var myResponse1 : MutableLiveData<Response<Services>> = MutableLiveData()
    var myResponseService : MutableLiveData<Response<Services>> = MutableLiveData()
    var myResponsePlanification : MutableLiveData<Response<Services>> = MutableLiveData()
    var myResponseAffecter : MutableLiveData<Response<Services>> = MutableLiveData()
    var myResponseActif : MutableLiveData<Response<Services>> = MutableLiveData()

    var myResponseStatus : MutableLiveData<Response<Services>> = MutableLiveData()

    var myResponsegetService : MutableLiveData<Response<Services>> = MutableLiveData()

    fun getListService(apikey: String,select: String,pageSize: Int,pageno: Int){
        viewModelScope.launch {

            val response = repository.getListService(apikey,select,pageSize,pageno)
            myResponse.value = response
        }
    }

    fun getService(apikey: String,ticketid: String,select: String){
        viewModelScope.launch {

            val response = repository.getService(apikey,ticketid,select)
            myResponsegetService.value = response
        }
    }



    fun getListService1(apikey: String,select: String,pageSize: Int,pageno: Int){
        viewModelScope.launch {

            val response = repository.getListService(apikey,select,pageSize,pageno)
            myResponse1.value = response
        }
    }


    fun getDetailService(apikey: String,ASSETNUM: String ,Myselect: String){
        viewModelScope.launch {
            val response1 = repository.getDetailService(apikey,ASSETNUM,Myselect)
            myResponseService.value = response1
        }
    }

    fun getServicePlanification(apikey: String,ASSETNUM: String ,Myselect: String){
        viewModelScope.launch {
            val response1 = repository.getServicePlanification(apikey,ASSETNUM,Myselect)
            myResponsePlanification.value = response1
        }
    }

    fun getServiceAffecter(apikey: String,ASSETNUM: String ,Myselect: String){
        viewModelScope.launch {
            val response1 = repository.getServiceAffecter(apikey,ASSETNUM,Myselect)
            myResponseAffecter.value = response1
        }
    }

    fun getServiceActif(apikey: String,ASSETNUM: String ,Myselect: String){
        viewModelScope.launch {
            val response1 = repository.getServiceActif(apikey,ASSETNUM,Myselect)
            myResponseActif.value = response1
        }
    }

    fun getStatusService(apikey: String,select: String){
        viewModelScope.launch {

            val response = repository.getStatusService(apikey,select)
            myResponseStatus.value = response
        }
    }


}