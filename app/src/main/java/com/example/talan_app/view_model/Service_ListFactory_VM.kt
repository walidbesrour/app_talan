package com.example.talan_app.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.talan_app.repository.RetrofitRepository
import com.example.talan_app.repository.RetrofitRepositoryService

class Service_ListFactory_VM (private val repository: RetrofitRepositoryService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return Service_List_VM(repository) as T
    }
}