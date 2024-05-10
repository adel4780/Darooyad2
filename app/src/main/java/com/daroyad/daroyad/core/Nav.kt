package com.daroyad.daroyad.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.daroyad.daroyad.views.pages.main.MainPage
import com.daroyad.daroyad.views.pages.prescriptions.PrescriptionsPage

@Composable
fun Nav() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "main_page") {
        composable("main_page") {
            MainPage(navHostController)
        }
    }
}