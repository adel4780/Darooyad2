package com.daroyad.daroyad.views.pages.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.daroyad.daroyad.views.pages.main.widgets.MainBottomBar
import com.daroyad.daroyad.views.pages.main.widgets.MainTopBar
import com.daroyad.daroyad.views.pages.menu.MenuPage
import com.daroyad.daroyad.views.pages.prescriptions.PrescriptionsPage
import com.daroyad.daroyad.views.pages.reminder.ReminderPage

@Composable
fun MainPage(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    var bottomBarIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            MainTopBar(modifier)
        },
        bottomBar = {
            MainBottomBar(
                bottomBarIndex = bottomBarIndex,
                onClick = { index ->
                    bottomBarIndex = index
                },
                modifier,
            )
        },
        containerColor = Color(0xFFFFFFFF),
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding),
        ) {
            when (bottomBarIndex) {
                0 -> ReminderPage()
                1 -> PrescriptionsPage(navHostController)
                2 -> MenuPage()
            }
        }
    }
}