package com.daroyad.daroyad.models.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.daroyad.daroyad.models.daos.MedicineDao
import com.daroyad.daroyad.models.daos.PrescriptionDao
import com.daroyad.daroyad.models.daos.ReminderDao
import com.daroyad.daroyad.models.entities.Medicine
import com.daroyad.daroyad.models.entities.Prescription
import com.daroyad.daroyad.models.entities.Reminder

/**
 * The main database class for the application, representing the Room database.
 * It includes the DAOs for medicines, prescriptions, and reminders.
 *
 * @property version The version number of the database schema.
 * @property entities The list of entities included in the database.
 */
@Database(entities = [Medicine::class, Prescription::class, Reminder::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    /**
     * Gets the MedicineDao for accessing medicine-related data.
     *
     * @return The MedicineDao instance.
     */
    abstract fun medicineDao(): MedicineDao

    /**
     * Gets the PrescriptionDao for accessing prescription-related data.
     *
     * @return The PrescriptionDao instance.
     */
    abstract fun prescriptionDao(): PrescriptionDao

    /**
     * Gets the ReminderDao for accessing reminder-related data.
     *
     * @return The ReminderDao instance.
     */
    abstract fun reminderDao(): ReminderDao
}
