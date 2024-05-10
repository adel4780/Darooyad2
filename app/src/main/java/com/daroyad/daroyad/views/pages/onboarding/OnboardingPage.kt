package com.daroyad.daroyad.views.pages.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.daroyad.daroyad.R
import kotlinx.coroutines.delay

import com.daroyad.daroyad.views.pages.prescriptions.widgets.AddPrescription
import com.daroyad.daroyad.views.pages.prescriptions.widgets.Prescription

@Composable
fun OnboardingPage(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box {
            Image(
                painter = painterResource(
                    id = R.drawable.onboarding_background,
                ),
                contentDescription = "onboarding_background",
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(
                        id = R.string.onboarding_title_1
                    ),
                    modifier = modifier.padding(
                        bottom = 15.0.dp,
                    ),
                    style = TextStyle(
                        color = Color(0xFF2D89FF),
                        fontSize = 32.0.sp,
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
                        id = R.string.onboarding_description_1
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
                    lineHeight = 24.0.sp,
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.onboarding_1),
            contentDescription = "onboarding_1"
        )
    }
}