package com.daroyad.daroyad.models.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.daroyad.daroyad.models.entities.Prescription

/**
 * Data Access Object (DAO) interface for accessing prescription-related data from the database.
 */
@Dao
interface PrescriptionDao {
    /**
     * Inserts a prescription entity into the database.
     *
     * @param prescription The prescription entity to be inserted.
     */
    @Insert
    suspend fun insertPrescription(prescription: Prescription)

    /**
     * Retrieves all prescriptions from the database.
     *
     * @return A list of all prescription entities.
     */
    @Query("SELECT * FROM prescriptions")
    suspend fun getAllPrescriptions(): List<Prescription>
}
