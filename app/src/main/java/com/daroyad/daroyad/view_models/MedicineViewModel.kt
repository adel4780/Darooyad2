package com.daroyad.daroyad.view_models

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daroyad.daroyad.models.database.AppDatabase
import com.daroyad.daroyad.models.entities.Medicine
import kotlinx.coroutines.launch

class MedicineViewModel(private val database: AppDatabase) : ViewModel() {

    val medicines = mutableStateListOf<Medicine>()

    init {
        loadMedicines()
    }

    fun addMedicine(medicine: Medicine) {
        viewModelScope.launch {
            database.medicineDao().insertMedicine(medicine)
            loadMedicines()
        }
    }

    private fun loadMedicines() {
        viewModelScope.launch {
            val allMedicines = database.medicineDao().getAllMedicines()
            medicines.clear()
            medicines.addAll(allMedicines)
        }
    }
}
