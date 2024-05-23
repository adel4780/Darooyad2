package com.daroyad.daroyad.models.database

import androidx.room.TypeConverter
import com.daroyad.daroyad.models.entities.Medicine
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Date

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromMedicineList(medicines: List<Medicine>?): String? {
        if (medicines == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Medicine>>() {}.type
        return gson.toJson(medicines, type)
    }

    @TypeConverter
    fun toMedicineList(medicinesString: String?): List<Medicine>? {
        if (medicinesString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Medicine>>() {}.type
        return gson.fromJson(medicinesString, type)
    }

    @TypeConverter
    fun fromLocalTime(localTime: LocalTime?): String? {
        return localTime?.format(DateTimeFormatter.ISO_LOCAL_TIME)
    }

    @TypeConverter
    fun toLocalTime(localTimeString: String?): LocalTime? {
        return localTimeString?.let {
            LocalTime.parse(it, DateTimeFormatter.ISO_LOCAL_TIME)
        }
    }
}

