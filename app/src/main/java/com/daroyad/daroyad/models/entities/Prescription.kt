package com.daroyad.daroyad.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "prescriptions")
data class Prescription(
    @PrimaryKey(autoGenerate = true) val id: Int = 1,
    val doctorName: String,
    val patientName: String,
    val date: Date,
    val medicines: List<Medicine>
)