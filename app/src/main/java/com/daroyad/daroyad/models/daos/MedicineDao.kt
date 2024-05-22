package com.daroyad.daroyad.models.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.daroyad.daroyad.models.entities.Medicine

@Dao
interface MedicineDao {
    @Insert
    suspend fun insertMedicine(medicine: Medicine)

    @Query("SELECT * FROM medicines")
    suspend fun getAllMedicines(): List<Medicine>
}
