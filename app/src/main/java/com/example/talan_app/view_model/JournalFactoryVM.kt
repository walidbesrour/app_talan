package com.example.talan_app.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.talan_app.repository.RetrofitRepositoryService

class JournalFactoryVM  (private val repository: RetrofitRepositoryService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return JournalVM(repository) as T
    }
}
