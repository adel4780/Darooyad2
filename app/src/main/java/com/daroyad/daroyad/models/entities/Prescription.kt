package com.daroyad.daroyad.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Data class representing a Prescription entity in the database.
 *
 * @property id The unique ID of the prescription (auto-generated).
 * @property doctorName The name of the doctor who issued the prescription.
 * @property patientName The name of the patient for whom the prescription is issued.
 * @property date The date when the prescription was issued.
 * @property medicines The list of medicines included in the prescription.
 */
@Entity(tableName = "prescriptions")
data class Prescription(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val doctorName: String,
    val patientName: String,
    val date: Date,
    val medicines: List<Medicine>
)