package com.example.talan_app.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.talan_app.repository.RetrofitRepositoryIntervention

class Intervention_ListFactory (private val repository: RetrofitRepositoryIntervention): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return Intervention_List_VM(repository) as T
    }
}