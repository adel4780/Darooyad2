package com.daroyad.daroyad.views.widgets


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.daroyad.daroyad.R

@Composable
fun TopAppBar(
    title: String,
    modifier: Modifier,
    navController: NavHostController

) {
    Row(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(
                    0.0.dp,
                    0.0.dp,
                    16.0.dp,
                    16.0.dp,
                ),
            )
            .size(
                width = LocalConfiguration.current.screenWidthDp.dp,
                height = 60.0.dp,
            )
            .background(
                Color(0xFF2D89FF),
            )
            .padding(
                25.0.dp,
                15.0.dp,
                25.0.dp,
                15.0.dp,
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {


        Text(
            text = title,
            style = TextStyle(
                color = Color(0xFFFFFFFF),
                fontSize = 16.0.sp,
                fontWeight = FontWeight.W700,
                fontFamily = FontFamily(
                    Font(
                        R.font.iranyekan_regular,
                    ),
                ),
            ),
        )
        Icon(
            imageVector = ImageVector.vectorResource(
                id = R.drawable.arrow_left,
            ),
            contentDescription = "logo_white",
            modifier = modifier
                .size(30.0.dp)
                .clickable { navController.navigateUp() },
            tint = Color(0xFFFFFFFF),
        )
    }
}
