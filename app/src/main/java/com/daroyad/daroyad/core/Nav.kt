package com.daroyad.daroyad.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.daroyad.daroyad.views.pages.main.MainPage
import com.daroyad.daroyad.views.pages.onboarding.OnboardingPage
import com.daroyad.daroyad.views.pages.prescriptions.PrescriptionsPage
import com.daroyad.daroyad.views.pages.splash.SplashPage

@Composable
fun Nav() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "splash_page") {
        composable("splash_page") {
            OnboardingPage(navHostController)
        }
        composable("onboarding_page") {
            OnboardingPage(navHostController)
        }
    }
}