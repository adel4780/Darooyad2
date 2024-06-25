package com.daroyad.daroyad.view_models

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daroyad.daroyad.models.database.AppDatabase
import com.daroyad.daroyad.models.entities.Prescription
import kotlinx.coroutines.launch

/**
 * ViewModel for managing prescription-related data and operations.
 *
 * @property database The [AppDatabase] instance for accessing the database.
 */
class PrescriptionViewModel(private val database: AppDatabase) : ViewModel() {

    /**
     * A mutable list of prescriptions that is observed by the UI.
     */
    val prescriptions = mutableStateListOf<Prescription>()

    /**
     * Initializes the ViewModel by loading the prescriptions from the database.
     */
    init {
        loadPrescriptions()
    }

    /**
     * Adds a new prescription to the database and refreshes the list of prescriptions.
     *
     * @param prescription The [Prescription] to be added to the database.
     */
    fun addPrescription(prescription: Prescription) {
        viewModelScope.launch {
            database.prescriptionDao().insertPrescription(prescription)
            loadPrescriptions()
        }
    }

    /**
     * Loads all prescriptions from the database and updates the list of prescriptions.
     */
    private fun loadPrescriptions() {
        viewModelScope.launch {
            val allPrescriptions = database.prescriptionDao().getAllPrescriptions()
            prescriptions.clear()
            prescriptions.addAll(allPrescriptions)
        }
    }
}
