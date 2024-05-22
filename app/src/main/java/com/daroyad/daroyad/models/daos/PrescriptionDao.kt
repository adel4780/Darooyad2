package com.daroyad.daroyad.models.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.daroyad.daroyad.models.entities.Prescription

@Dao
interface PrescriptionDao {
    @Insert
    suspend fun insertPrescription(prescription: Prescription)

    @Query("SELECT * FROM prescriptions")
    suspend fun getAllPrescriptions(): List<Prescription>
}
