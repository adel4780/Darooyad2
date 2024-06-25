package com.daroyad.daroyad.models.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.daroyad.daroyad.models.entities.Medicine

/**
 * Data Access Object (DAO) interface for accessing medicine-related data from the database.
 */
@Dao
interface MedicineDao {
    /**
     * Inserts a medicine entity into the database.
     *
     * @param medicine The medicine entity to be inserted.
     */
    @Insert
    suspend fun insertMedicine(medicine: Medicine)

    /**
     * Retrieves all medicines from the database.
     *
     * @return A list of all medicine entities.
     */
    @Query("SELECT * FROM medicines")
    suspend fun getAllMedicines(): List<Medicine>
}
