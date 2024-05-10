package com.daroyad.daroyad.views.pages.prescriptions.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.daroyad.daroyad.R
import com.daroyad.daroyad.views.pages.main.widgets.MainBottomBar
import com.daroyad.daroyad.views.pages.main.widgets.MainTopBar
import com.daroyad.daroyad.views.pages.menu.MenuPage
import com.daroyad.daroyad.views.pages.prescriptions.widgets.PrescriptionsEmpty
import com.daroyad.daroyad.views.pages.reminder.ReminderPage

@Composable
fun AddPrescription(modifier: Modifier) {
    FloatingActionButton(
        onClick = { },
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