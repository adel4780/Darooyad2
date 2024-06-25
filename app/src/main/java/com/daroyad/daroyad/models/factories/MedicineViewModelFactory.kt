package com.daroyad.daroyad.models.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.daroyad.daroyad.models.database.AppDatabase
import com.daroyad.daroyad.view_models.MedicineViewModel

/**
 * Factory class for creating instances of [MedicineViewModel].
 *
 * @property database The [AppDatabase] instance used to create the [MedicineViewModel].
 */
class MedicineViewModelFactory(private val database: AppDatabase) : ViewModelProvider.Factory {
    /**
     * Creates a new instance of the specified [ViewModel] class.
     *
     * @param modelClass The class of the [ViewModel] to create.
     * @return A new instance of the specified [ViewModel] class.
     * @throws IllegalArgumentException If the specified class is not assignable from [MedicineViewModel].
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MedicineViewModel::class.java)) {
            return MedicineViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
