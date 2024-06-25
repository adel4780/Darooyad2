package com.daroyad.daroyad.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Data class representing a Reminder entity in the database.
 *
 * @property id The unique ID of the reminder (auto-generated).
 * @property medicineName The name of the medicine for which the reminder is set.
 * @property patientName The name of the patient for whom the reminder is set.
 * @property time The time at which the reminder is set.
 */
@Entity(tableName = "reminders")
data class Reminder(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val medicineName: String,
    val patientName: String,
    val time: Date
)
