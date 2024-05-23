package com.daroyad.daroyad.views.pages.reminder

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.daroyad.daroyad.MedicineScreen
import com.daroyad.daroyad.models.database.DatabaseProvider
import com.daroyad.daroyad.models.factories.PrescriptionViewModelFactory
import com.daroyad.daroyad.models.factories.ReminderViewModelFactory
import com.daroyad.daroyad.view_models.PrescriptionViewModel
import com.daroyad.daroyad.view_models.ReminderViewModel
import com.daroyad.daroyad.views.pages.prescriptions.widgets.AddPrescription
import com.daroyad.daroyad.views.pages.prescriptions.widgets.PrescriptionItem
import com.daroyad.daroyad.views.pages.prescriptions.widgets.PrescriptionsEmpty
import com.daroyad.daroyad.views.pages.reminder.widgets.ReminderEmpty
import com.daroyad.daroyad.views.pages.reminder.widgets.ReminderItem

@Composable
fun ReminderPage(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val database = DatabaseProvider.getDatabase(context)
    val factory = ReminderViewModelFactory(database)
    val reminderViewModel: ReminderViewModel = viewModel(factory = factory)

    val reminders = reminderViewModel.reminders

    Scaffold(
        containerColor = Color(0x00000000),
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding),
        ) {
            if (reminders.isEmpty()) {
                ReminderEmpty()
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    items(reminders.size) {
                        ReminderItem(
                            reminder = reminders[it],
                        )
                    }
                }
            }
        }
    }
}

