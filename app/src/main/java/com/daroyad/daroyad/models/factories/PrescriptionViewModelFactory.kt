package com.daroyad.daroyad.models.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.daroyad.daroyad.models.database.AppDatabase
import com.daroyad.daroyad.view_models.PrescriptionViewModel

class PrescriptionViewModelFactory(private val database: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PrescriptionViewModel::class.java)) {
            return PrescriptionViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
