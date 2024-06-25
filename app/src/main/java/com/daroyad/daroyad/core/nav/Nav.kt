package com.daroyad.daroyad.core.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.daroyad.daroyad.models.database.DatabaseProvider
import com.daroyad.daroyad.models.entities.Medicine
import com.daroyad.daroyad.models.entities.Prescription
import com.daroyad.daroyad.models.factories.MedicineViewModelFactory
import com.daroyad.daroyad.models.factories.PrescriptionViewModelFactory
import com.daroyad.daroyad.view_models.MedicineViewModel
import com.daroyad.daroyad.view_models.PrescriptionViewModel
import com.daroyad.daroyad.views.pages.add_prescription.AddPrescriptionPage
import com.daroyad.daroyad.views.pages.main.MainPage
import com.daroyad.daroyad.views.pages.medicine.MedicinePage
import com.daroyad.daroyad.views.pages.medicines.MedicinesPage
import com.daroyad.daroyad.views.pages.onboarding.OnboardingPage
import com.daroyad.daroyad.views.pages.prescription.PrescriptionPage
import com.daroyad.daroyad.views.pages.splash.SplashPage
import java.time.LocalTime
import java.util.Date

/**
 * Singleton object to hold global state variables related to prescriptions and medicines.
 */
object GlobalState {
    var prescription by mutableStateOf(
        Prescription(
            doctorName = "",
            patientName = "",
            date = Date(),
            medicines = emptyList()
        )
    )

    var medicine by mutableStateOf(
        Medicine(
            medicineName = "",
            period = "",
            number = 1,
            startDate = Date(),
            startTime = LocalTime.parse("12:02"),
            description = ""
        )
    )

    var prescriptions by mutableStateOf<List<Prescription>>(emptyList())

    var medicines by mutableStateOf<List<Medicine>>(emptyList())
}

/**
 * Composable function to load prescriptions from the database and update the global state.
 */
@Composable
fun LoadPrescriptions() {
    val context = LocalContext.current
    val database = DatabaseProvider.getDatabase(context)
    val factory = PrescriptionViewModelFactory(database)
    val prescriptionViewModel: PrescriptionViewModel = viewModel(factory = factory)

    GlobalState.prescriptions = prescriptionViewModel.prescriptions
}

/**
 * Composable function to load medicines from the database and update the global state.
 */
@Composable
fun LoadMedicines() {
    val context = LocalContext.current
    val database = DatabaseProvider.getDatabase(context)
    val factory = MedicineViewModelFactory(database)
    val medicineViewModel: MedicineViewModel = viewModel(factory = factory)

    GlobalState.medicines = medicineViewModel.medicines
}

/**
 * Composable function to set up the navigation host and handle navigation between different pages.
 */
@Composable
fun Nav() {
    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = PagesRouteEnum.SPLASH.route,
    ) {
        composable(PagesRouteEnum.SPLASH.route) {
            SplashPage(navHostController)
        }
        composable(PagesRouteEnum.ONBOARDING.route) {
            OnboardingPage(navHostController)
        }
        composable(PagesRouteEnum.MAIN.route) {
            MainPage(navHostController)
        }
        composable(route = PagesRouteEnum.PRESCRIPTION.route) {
            PrescriptionPage(navHostController)
        }
        composable(PagesRouteEnum.SHOW_PRESCRIPTION.route) {
//            PrescriptionPage(navHostController)
        }
        composable(PagesRouteEnum.ADD_PRESCRIPTION.route) {
            AddPrescriptionPage(navHostController)
        }
        composable(PagesRouteEnum.EDIT_PRESCRIPTION.route) {
//            PrescriptionPage(navHostController)
        }
        composable(PagesRouteEnum.SHOW_MEDICINE.route) {
            MedicinePage(
                navHostController, isShow = true)
        }
        composable(PagesRouteEnum.ADD_MEDICINE.route) {
            MedicinePage(navHostController)
        }
        composable(PagesRouteEnum.EDIT_MEDICINE.route) {
            MedicinePage(navHostController, isEdit = true)
        }
        composable(PagesRouteEnum.MEDICINES_PAGE.route) {
            MedicinesPage(navHostController)
        }
    }
}
