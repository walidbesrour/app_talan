package com.example.talan_app.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.talan_app.repository.RetrofitRepository


class CompteurFactory_VM (private val repository: RetrofitRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return Compteur_List_VM(repository) as T
    }
}