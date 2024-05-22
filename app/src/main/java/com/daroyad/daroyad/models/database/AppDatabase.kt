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

@Database(entities = [Medicine::class, Prescription::class, Reminder::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun medicineDao(): MedicineDao
    abstract fun prescriptionDao(): PrescriptionDao
    abstract fun reminderDao(): ReminderDao
}
