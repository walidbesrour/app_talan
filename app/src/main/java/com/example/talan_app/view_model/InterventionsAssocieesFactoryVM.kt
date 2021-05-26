package com.example.talan_app.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.talan_app.repository.RetrofitRepository

class InterventionsAssocieesFactoryVM (private val repository: RetrofitRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InterventionsAssocieesVM(repository) as T
    }
}