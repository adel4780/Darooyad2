package com.daroyad.daroyad.views.pages.main.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daroyad.daroyad.R

@Composable
fun BottomBarItemInactive(
    title: Int,
    icon: Int,
    onClick: () -> Unit,
    modifier: Modifier,
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(
            8.0.dp,
        ),
        color = Color(0x00000000),
    ) {
        Column(
            modifier = Modifier
                .size(
                    width = 60.0.dp,
                    height = 60.0.dp,
                )
                .padding(
                    5.0.dp,
                )
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(
                    id = icon,
                ),
                contentDescription = "bottom_bar_item_active",
                modifier = modifier.size(20.0.dp),
                tint = Color(0xFFAEBBCC),
            )
            Text(
                text = stringResource(
                    id = title,
                ),
                style = TextStyle(
                    color = Color(0xFFAEBBCC),
                    fontSize = 10.0.sp,
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
}