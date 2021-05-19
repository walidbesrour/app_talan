package com.example.talan_app.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.talan_app.repository.RetrofitRepository

class PieceDetacheeFactory (private val repository: RetrofitRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PieceDetacheeVM(repository) as T
    }
}