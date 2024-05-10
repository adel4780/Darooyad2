package com.daroyad.daroyad.views.pages.prescriptions.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.daroyad.daroyad.R

@Composable
fun PrescriptionsEmpty(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(
                id = R.string.prescriptions_empty,
            ),
            style = TextStyle(
                color = Color(0xFF000000),
                fontSize = 16.0.sp,
                fontWeight = FontWeight.W700,
                fontFamily = FontFamily(
                    Font(
                        R.font.iranyekan_regular,
                    ),
                ),
            ),
        )
    }
}