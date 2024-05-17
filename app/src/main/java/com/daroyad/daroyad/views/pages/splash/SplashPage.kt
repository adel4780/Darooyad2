package com.daroyad.daroyad.views.pages.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.daroyad.daroyad.R
import com.daroyad.daroyad.core.nav.PagesRouteEnum
import kotlinx.coroutines.delay

@Composable
fun SplashPage(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        navHostController.navigate(PagesRouteEnum.ONBOARDING.route) {
            popUpTo(PagesRouteEnum.SPLASH.route) {
                inclusive = true
            }
        }
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = modifier.padding(
                48.0.dp,
                29.0.dp,
                29.0.dp,
                0.0.dp,
            )
        ) {
            Text(
                text = stringResource(
                    id = R.string.app_name_fa
                ),
                modifier = modifier.padding(
                    bottom = 15.0.dp,
                ),
                style = TextStyle(
                    color = Color(0xFF2D89FF),
                    fontSize = 64.0.sp,
                    fontWeight = FontWeight.W700,
                    fontFamily = FontFamily(
                        Font(
                            R.font.iranyekan_regular,
                        ),
                    ),
                ),
            )
            Text(
                text = stringResource(
                    id = R.string.splash
                ),
                style = TextStyle(
                    color = Color(0xFF000000),
                    fontSize = 18.0.sp,
                    fontWeight = FontWeight.W700,
                    fontFamily = FontFamily(
                        Font(
                            R.font.iranyekan_regular,
                        ),
                    ),
                ),
                lineHeight = 24.0.sp,
            )
        }
        Image(
            painter = painterResource(
                id = R.drawable.splash,
            ),
            contentDescription = "splash",
        )
    }
}