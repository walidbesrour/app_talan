package com.example.talan_app.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.talan_app.repository.RetrofitRepositoryIntervention

class PlanInterVMFactory (private val repository: RetrofitRepositoryIntervention): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlanInterVM(repository) as T
    }
}