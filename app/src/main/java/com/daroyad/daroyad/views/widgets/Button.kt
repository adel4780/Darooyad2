package com.daroyad.daroyad.views.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daroyad.daroyad.R

@Composable
fun MyButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(16.dp),
        shape = RoundedCornerShape(32.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2D89FF))
    ) {
        Text(
            modifier = Modifier.padding(4.dp, 4.dp, 4.dp, 8.dp), text = text, color = Color.White, style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                fontFamily = FontFamily(
                    Font(
                        R.font.iranyekan_regular,
                    ),
                ),
            )
        )
    }
}
