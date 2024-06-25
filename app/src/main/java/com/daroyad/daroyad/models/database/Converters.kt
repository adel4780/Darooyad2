package com.daroyad.daroyad.models.database

import androidx.room.TypeConverter
import com.daroyad.daroyad.models.entities.Medicine
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Date

/**
 * Converters class for handling complex data types in the Room database.
 */
class Converters {
    /**
     * Converts a timestamp to a Date object.
     *
     * @param value The timestamp value.
     * @return The corresponding Date object or null if the value is null.
     */
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    /**
     * Converts a Date object to a timestamp.
     *
     * @param date The Date object.
     * @return The corresponding timestamp or null if the date is null.
     */
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    /**
     * Converts a list of Medicine objects to a JSON string.
     *
     * @param medicines The list of Medicine objects.
     * @return The JSON string representation of the list or null if the list is null.
     */
    @TypeConverter
    fun fromMedicineList(medicines: List<Medicine>?): String? {
        if (medicines == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Medicine>>() {}.type
        return gson.toJson(medicines, type)
    }

    /**
     * Converts a JSON string to a list of Medicine objects.
     *
     * @param medicinesString The JSON string.
     * @return The list of Medicine objects or null if the string is null.
     */
    @TypeConverter
    fun toMedicineList(medicinesString: String?): List<Medicine>? {
        if (medicinesString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Medicine>>() {}.type
        return gson.fromJson(medicinesString, type)
    }

    /**
     * Converts a LocalTime object to a string.
     *
     * @param localTime The LocalTime object.
     * @return The string representation of the LocalTime or null if the LocalTime is null.
     */
    @TypeConverter
    fun fromLocalTime(localTime: LocalTime?): String? {
        return localTime?.format(DateTimeFormatter.ISO_LOCAL_TIME)
    }

    /**
     * Converts a string to a LocalTime object.
     *
     * @param localTimeString The string representation of the LocalTime.
     * @return The corresponding LocalTime object or null if the string is null.
     */
    @TypeConverter
    fun toLocalTime(localTimeString: String?): LocalTime? {
        return localTimeString?.let {
            LocalTime.parse(it, DateTimeFormatter.ISO_LOCAL_TIME)
        }
    }
}
