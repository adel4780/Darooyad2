package com.daroyad.daroyad.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.daroyad.daroyad.models.database.DateSerializer
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalTime
import java.util.Date

@Entity(tableName = "medicines")
@Serializable
data class Medicine(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val medicineName: String,
    val period: String,
    val number: Int,
    @Serializable(with = DateSerializer::class) val startDate: Date,
    @Contextual val startTime: LocalTime,
    val description: String
)