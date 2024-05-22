package com.daroyad.daroyad.views.pages.prescriptions

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.daroyad.daroyad.R
import com.daroyad.daroyad.views.pages.main.widgets.MainBottomBar
import com.daroyad.daroyad.views.pages.main.widgets.MainTopBar
import com.daroyad.daroyad.views.pages.menu.MenuPage
import com.daroyad.daroyad.views.pages.prescriptions.widgets.AddPrescription
import com.daroyad.daroyad.views.pages.prescriptions.widgets.Prescription
import com.daroyad.daroyad.views.pages.prescriptions.widgets.PrescriptionsEmpty
import com.daroyad.daroyad.views.pages.reminder.ReminderPage

@Composable
fun PrescriptionsPage(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        floatingActionButton = { AddPrescription(navController, modifier) },
        containerColor = Color(0x00000000),
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding),
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                items(10) {
                    Prescription(navController = navController)
                }
            }
        }
    }
}