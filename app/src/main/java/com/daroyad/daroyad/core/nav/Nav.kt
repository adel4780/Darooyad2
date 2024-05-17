package com.daroyad.daroyad.core.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.daroyad.daroyad.views.pages.main.MainPage
import com.daroyad.daroyad.views.pages.onboarding.OnboardingPage
import com.daroyad.daroyad.views.pages.splash.SplashPage
import com.daroyad.daroyad.views.pages.medicine.MedicinePage
import com.daroyad.daroyad.views.pages.medicines.MedicinesPage
import com.daroyad.daroyad.views.pages.prescription.widgets.PrescriptionPage

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
        composable("show_prescriptions") {
            PrescriptionPage(navHostController, isShow = true)
        }
        composable("add_prescriptions") {
            PrescriptionPage(navHostController)
        }
        composable("edit_prescriptions") {
            PrescriptionPage(navHostController, isEdit = true)
        }
        composable("show_medicine") {
            MedicinePage(navHostController, isShow = true)
        }
        composable("add_medicine") {
            MedicinePage(navHostController)
        }
        composable("edit_medicine") {
            MedicinePage(navHostController, isEdit = true)
        }
        composable("medicines_page") {
            MedicinesPage(navHostController,)
        }
    }
}