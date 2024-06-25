package com.daroyad.daroyad.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalTime
import java.util.Date

/**
 * Data class representing a Medicine entity in the database.
 *
 * @property id The unique ID of the medicine (auto-generated).
 * @property medicineName The name of the medicine.
 * @property period The period for taking the medicine.
 * @property number The number of times the medicine is taken.
 * @property startDate The start date for taking the medicine.
 * @property startTime The start time for taking the medicine.
 * @property description Additional description about the medicine.
 */
@Entity(tableName = "medicines")
data class Medicine(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val medicineName: String,
    val period: String,
    val number: Int,
    val startDate: Date,
    val startTime: LocalTime,
    val description: String
)
