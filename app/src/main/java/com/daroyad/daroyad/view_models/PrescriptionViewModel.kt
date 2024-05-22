package com.daroyad.daroyad.view_models

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daroyad.daroyad.models.database.AppDatabase
import com.daroyad.daroyad.models.entities.Prescription
import kotlinx.coroutines.launch

class PrescriptionViewModel(private val database: AppDatabase) : ViewModel() {

    val prescriptions = mutableStateListOf<Prescription>()

    init {
        loadPrescriptions()
    }

    fun addPrescription(prescription: Prescription) {
        viewModelScope.launch {
            database.prescriptionDao().insertPrescription(prescription)
            loadPrescriptions()
        }
    }

    private fun loadPrescriptions() {
        viewModelScope.launch {
            val allPrescriptions = database.prescriptionDao().getAllPrescriptions()
            prescriptions.clear()
            prescriptions.addAll(allPrescriptions)
        }
    }
}
