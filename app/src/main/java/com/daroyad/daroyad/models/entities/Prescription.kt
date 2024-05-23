package com.daroyad.daroyad.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.daroyad.daroyad.models.database.DateSerializer
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.Date

@Entity(tableName = "prescriptions")
@Serializable
data class Prescription(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val doctorName: String,
    val patientName: String,
    @Serializable(with = DateSerializer::class) val date: Date,
    val medicines: List<Medicine>
)