package com.daroyad.daroyad.view_models

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daroyad.daroyad.models.database.AppDatabase
import com.daroyad.daroyad.models.entities.Reminder
import kotlinx.coroutines.launch

/**
 * ViewModel for managing reminder-related data and operations.
 *
 * @property database The [AppDatabase] instance for accessing the database.
 */
class ReminderViewModel(private val database: AppDatabase) : ViewModel() {

    /**
     * A mutable list of reminders that is observed by the UI.
     */
    val reminders = mutableStateListOf<Reminder>()

    /**
     * Initializes the ViewModel by loading the reminders from the database.
     */
    init {
        loadReminders()
    }

    /**
     * Adds a new reminder to the database and refreshes the list of reminders.
     *
     * @param reminder The [Reminder] to be added to the database.
     */
    fun addReminder(reminder: Reminder) {
        viewModelScope.launch {
            database.reminderDao().insertReminder(reminder)
            loadReminders()
        }
    }

    /**
     * Loads all reminders from the database and updates the list of reminders.
     */
    private fun loadReminders() {
        viewModelScope.launch {
            val allReminders = database.reminderDao().getAllReminders()
            reminders.clear()
            reminders.addAll(allReminders)
        }
    }
}
