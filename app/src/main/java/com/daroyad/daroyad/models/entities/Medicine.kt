package com.daroyad.daroyad.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalTime
import java.util.Date

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