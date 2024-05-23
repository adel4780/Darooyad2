package com.daroyad.daroyad.views.pages.prescriptions

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
import androidx.navigation.NavHostController
import com.daroyad.daroyad.models.database.DatabaseProvider
import com.daroyad.daroyad.models.factories.PrescriptionViewModelFactory
import com.daroyad.daroyad.view_models.PrescriptionViewModel
import com.daroyad.daroyad.views.pages.prescriptions.widgets.AddPrescription
import com.daroyad.daroyad.views.pages.prescriptions.widgets.PrescriptionItem
import com.daroyad.daroyad.views.pages.prescriptions.widgets.PrescriptionsEmpty

@Composable
fun PrescriptionsPage(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val database = DatabaseProvider.getDatabase(context)
    val factory = PrescriptionViewModelFactory(database)
    val prescriptionViewModel: PrescriptionViewModel = viewModel(factory = factory)

    val prescriptions = prescriptionViewModel.prescriptions

    Scaffold(
        floatingActionButton = { AddPrescription(navController, modifier) },
        containerColor = Color(0x00000000),
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding),
        ) {
            if (prescriptions.isEmpty()) {
                PrescriptionsEmpty()
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    items(prescriptions.size) {
                        PrescriptionItem(
                            prescription = prescriptions[it],
                            navController = navController,
                        )
                    }
                }
            }
        }
    }
}