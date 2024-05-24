package com.daroyad.daroyad.views.pages.prescriptions.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daroyad.daroyad.R

@Composable
fun PrescriptionInfo(title: Int, info: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                20.0.dp,
                15.0.dp,
                20.0.dp,
                0.0.dp,
            ),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(
                id = title,
            )+" ",
            style = TextStyle(
                color = Color(0xFF2D89FF),
                fontSize = 20.0.sp,
                fontWeight = FontWeight.W700,
                fontFamily = FontFamily(
                    Font(
                        R.font.iranyekan_regular,
                    ),
                ),
            ),
        )
        Text(
            text = info,
            style = TextStyle(
                color = Color(0xFF000000),
                fontSize = 18.0.sp,
                fontWeight = FontWeight.W300,
                fontFamily = FontFamily(
                    Font(
                        R.font.iranyekan_regular,
                    ),
                ),
            ),
        )
    }
}