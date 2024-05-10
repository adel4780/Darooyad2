package com.daroyad.daroyad.views.pages.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.daroyad.daroyad.R
import com.daroyad.daroyad.views.pages.menu.widgets.Logout
import com.daroyad.daroyad.views.pages.menu.widgets.Menu

@Composable
fun MenuPage(
    modifier: Modifier = Modifier,
) {
    var menuIndex by remember { mutableIntStateOf(-1) }

    Scaffold(
        containerColor = Color(0x00000000),
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Menu(
                title = R.string.about_app_title,
                icon = R.drawable.logo,
                text = R.string.about_app_text,
                isVisible = menuIndex == 0,
                onClick = {
                    menuIndex = if (menuIndex == 0) -1 else 0
                },
                modifier = modifier,
            )
            Menu(
                title = R.string.about_us_title,
                icon = R.drawable.about_us,
                text = R.string.about_us_text,
                isVisible = menuIndex == 1,
                onClick = {
                    menuIndex = if (menuIndex == 1) -1 else 1
                },
                modifier = modifier,
            )
            Logout(
                modifier = modifier,
            )
        }
    }
}