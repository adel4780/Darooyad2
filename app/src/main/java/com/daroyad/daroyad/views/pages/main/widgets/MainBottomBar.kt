package com.daroyad.daroyad.views.pages.main.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.daroyad.daroyad.R

@Composable
fun MainBottomBar(
    bottomBarIndex: Int,
    onClick: (Int) -> Unit,
    modifier: Modifier,
) {
    Surface(
        modifier = Modifier
            .size(
                width = LocalConfiguration.current.screenWidthDp.dp,
                height = 90.0.dp,
            )
            .fillMaxSize()
            .shadow(
                elevation = 20.dp,
                shape = MaterialTheme.shapes.medium,
                ambientColor = Color(0xFF000000),
                spotColor = Color(0x00000000),
            ),
        color = Color(0xFFFFFFFF),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 50.0.dp,
                    vertical = 18.0.dp,
                ),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (bottomBarIndex == 0) {
                    BottomBarItemActive(
                        title = R.string.reminder,
                        icon = R.drawable.reminder_active,
                        modifier = modifier
                    )
                } else {
                    BottomBarItemInactive(
                        title = R.string.reminder,
                        icon = R.drawable.reminder_active,
                        modifier = modifier,
                        onClick = { onClick(0) },
                    )
                }
                if (bottomBarIndex == 1) {
                    BottomBarItemActive(
                        title = R.string.prescriptions,
                        icon = R.drawable.prescriptions_inactive,
                        modifier = modifier
                    )
                } else {
                    BottomBarItemInactive(
                        title = R.string.prescriptions,
                        icon = R.drawable.prescriptions_inactive,
                        modifier = modifier,
                        onClick = { onClick(1) },
                    )
                }
                if (bottomBarIndex == 2) {
                    BottomBarItemActive(
                        title = R.string.menu,
                        icon = R.drawable.menu_inactive,
                        modifier = modifier,
                    )
                } else {
                    BottomBarItemInactive(
                        title = R.string.menu,
                        icon = R.drawable.menu_inactive,
                        modifier = modifier,
                        onClick = { onClick(2) },
                    )
                }
            }
        }
    }
}