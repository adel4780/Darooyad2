package com.daroyad.daroyad.views.pages.prescriptions.widgets

import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.daroyad.daroyad.R
import com.daroyad.daroyad.core.nav.PagesRouteEnum
import com.daroyad.daroyad.core.nav.LoadPrescriptions as LoadPrescriptions

@Composable
fun AddPrescription(
    navController: NavHostController,
    modifier: Modifier
) {
    FloatingActionButton(
        onClick = {
            navController.navigate(
                route = PagesRouteEnum.ADD_PRESCRIPTION.route,
            )
        },
        containerColor = Color(0xFF2D89FF),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(
                id = R.drawable.add_prescription,
            ),
            contentDescription = "bottom_bar_item_active",
            modifier = modifier.size(30.0.dp),
            tint = Color(0xFFFFFFFF),
        )
    }
}