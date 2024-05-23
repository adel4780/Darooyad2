package com.daroyad.daroyad.core.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.daroyad.daroyad.models.entities.Prescription
import com.daroyad.daroyad.views.pages.main.MainPage
import com.daroyad.daroyad.views.pages.medicine.MedicinePage
import com.daroyad.daroyad.views.pages.medicines.MedicinesPage
import com.daroyad.daroyad.views.pages.onboarding.OnboardingPage
import com.daroyad.daroyad.views.pages.add_prescription.AddPrescriptionPage
import com.daroyad.daroyad.views.pages.prescription.PrescriptionPage
import com.daroyad.daroyad.views.pages.splash.SplashPage
import com.squareup.moshi.Moshi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

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
        composable(PagesRouteEnum.PRESCRIPTION.route) { backStackEntry ->
            val prescriptionJson =  backStackEntry.arguments?.getString("prescription")
            val moshi = Moshi.Builder().build()
            val jsonAdapter = moshi.adapter(Prescription::class.java).lenient()
            val prescription = jsonAdapter.fromJson(prescriptionJson)

            PrescriptionPage(
                prescription = prescription!!,
                navHostController,
            )
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
            MedicinePage(navHostController, isShow = true)
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