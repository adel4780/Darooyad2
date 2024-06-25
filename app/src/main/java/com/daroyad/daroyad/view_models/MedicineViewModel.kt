package com.daroyad.daroyad.view_models

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daroyad.daroyad.models.database.AppDatabase
import com.daroyad.daroyad.models.entities.Medicine
import kotlinx.coroutines.launch

/**
 * ViewModel for managing medicine-related data and operations.
 *
 * @property database The [AppDatabase] instance for accessing the database.
 */
class MedicineViewModel(private val database: AppDatabase) : ViewModel() {

    /**
     * A mutable list of medicines that is observed by the UI.
     */
    val medicines = mutableStateListOf<Medicine>()

    /**
     * Initializes the ViewModel by loading the medicines from the database.
     */
    init {
        loadMedicines()
    }

    /**
     * Adds a new medicine to the database and refreshes the list of medicines.
     *
     * @param medicine The [Medicine] to be added to the database.
     */
    fun addMedicine(medicine: Medicine) {
        viewModelScope.launch {
            database.medicineDao().insertMedicine(medicine)
            loadMedicines()
        }
    }

    /**
     * Loads all medicines from the database and updates the list of medicines.
     */
    private fun loadMedicines() {
        viewModelScope.launch {
            val allMedicines = database.medicineDao().getAllMedicines()
            medicines.clear()
            medicines.addAll(allMedicines)
        }
    }
}
