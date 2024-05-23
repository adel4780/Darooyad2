package com.daroyad.daroyad

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.daroyad.daroyad.models.database.DatabaseProvider
import com.daroyad.daroyad.models.entities.Medicine
import com.daroyad.daroyad.models.factories.MedicineViewModelFactory
import com.daroyad.daroyad.view_models.MedicineViewModel
import java.time.LocalTime
import java.util.Date

@Composable
fun MedicineScreen() {
    val context = LocalContext.current
    val database = DatabaseProvider.getDatabase(context)
    val factory = MedicineViewModelFactory(database)
    val medicineViewModel: MedicineViewModel = viewModel(factory = factory)

    val medicines = medicineViewModel.medicines

    // UI برای نمایش لیست داروها
    Column {
        medicines.forEach { medicine ->
            Text(text = "${medicine.medicineName}, ${medicine.description}")
        }

        // اضافه کردن داروی جدید
        Button(onClick = {
            medicineViewModel.addMedicine(
                Medicine(
                    medicineName = "New Medicine",
                    period = "Daily",
                    number = 1,
                    startDate = Date(),
                    startTime = LocalTime.now(),
                    description = "Description"
                )
            )
        }) {
            Text(text = "Add Medicine")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MedicineScreenPreview() {
    MedicineScreen()
}
