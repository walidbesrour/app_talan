package com.example.talan_app.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.talan_app.model.Actifs
import com.example.talan_app.model.PieceJoint
import com.example.talan_app.repository.RetrofitRepository
import kotlinx.coroutines.launch
import retrofit2.Response


class Actif_List_VM (private val repository: RetrofitRepository): ViewModel() {



    var myResponse : MutableLiveData<Response<Actifs>> = MutableLiveData()
    var myResponse11 : MutableLiveData<Response<Actifs>> = MutableLiveData()

    var myResponse1 : MutableLiveData<Response<Actifs>> = MutableLiveData()

    var myResponsefils : MutableLiveData<Response<Actifs>> = MutableLiveData()

    var myResponseDetail : MutableLiveData<Response<Actifs>> = MutableLiveData()

    var myResponseJoint : MutableLiveData<Response<PieceJoint>> = MutableLiveData()


    fun getActif(apikey: String, parent: String,select: String){
        viewModelScope.launch {

            val response = repository.getActif(apikey,parent,select)
            myResponse1.value = response
        }
    }


    fun getListActifs(apikey: String,select: String,pageSize: Int,pageno: Int){
        viewModelScope.launch {

            val response = repository.getListActif(apikey,select,pageSize,pageno)
            myResponse.value = response
        }
    }

    fun getListActifs11(apikey: String,select: String,pageSize: Int,pageno: Int){
        viewModelScope.launch {

            val response = repository.getListActif(apikey,select,pageSize,pageno)
            myResponse11.value = response
        }
    }


    fun getListActifFils(apikey: String,select: String,parent: String,siteid: String){
        viewModelScope.launch {
            val response1 = repository.getListActifFils(apikey,select,parent,siteid)
            myResponsefils.value = response1
        }
    }

    fun getDetailActif(apikey: String,ASSETNUM: String ,Myselect: String){
        viewModelScope.launch {
            val response1 = repository.getDetailActif(apikey,ASSETNUM,Myselect)
            myResponseDetail.value = response1
        }
    }

    fun getPieceActif(apikey: String,ASSETNUM: String ,Myselect: String){
        viewModelScope.launch {
            val response1 = repository.getPieceActif(apikey,ASSETNUM,Myselect)
            myResponseJoint.value = response1
        }
    }

}