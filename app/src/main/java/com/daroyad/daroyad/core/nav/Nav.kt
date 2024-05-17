package com.daroyad.daroyad.core.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.daroyad.daroyad.views.pages.main.MainPage
import com.daroyad.daroyad.views.pages.onboarding.OnboardingPage
import com.daroyad.daroyad.views.pages.splash.SplashPage

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
    }
}