package com.daroyad.daroyad.models.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.daroyad.daroyad.models.entities.Reminder

/**
 * Data Access Object (DAO) interface for accessing reminder-related data from the database.
 */
@Dao
interface ReminderDao {
    /**
     * Inserts a reminder entity into the database.
     *
     * @param reminder The reminder entity to be inserted.
     */
    @Insert
    suspend fun insertReminder(reminder: Reminder)

    /**
     * Retrieves all reminders from the database.
     *
     * @return A list of all reminder entities.
     */
    @Query("SELECT * FROM reminders")
    suspend fun getAllReminders(): List<Reminder>
}
