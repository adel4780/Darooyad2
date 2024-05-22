package com.daroyad.daroyad.views.pages.reminder

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.daroyad.daroyad.MedicineScreen
import com.daroyad.daroyad.views.pages.prescriptions.widgets.AddPrescription
import com.daroyad.daroyad.views.pages.prescriptions.widgets.PrescriptionsEmpty
import com.daroyad.daroyad.views.pages.reminder.widgets.Reminder

@Composable
fun ReminderPage(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        containerColor = Color(0x00000000),
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding),
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
            ) {
                items(10) {
                    Reminder()
                }
            }
        }
    }
}

