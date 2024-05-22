package com.daroyad.daroyad.view_models

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daroyad.daroyad.models.database.AppDatabase
import com.daroyad.daroyad.models.entities.Reminder
import kotlinx.coroutines.launch

class ReminderViewModel(private val database: AppDatabase) : ViewModel() {

    val reminders = mutableStateListOf<Reminder>()

    init {
        loadReminders()
    }

    fun addReminder(reminder: Reminder) {
        viewModelScope.launch {
            database.reminderDao().insertReminder(reminder)
            loadReminders()
        }
    }

    private fun loadReminders() {
        viewModelScope.launch {
            val allReminders = database.reminderDao().getAllReminders()
            reminders.clear()
            reminders.addAll(allReminders)
        }
    }
}
