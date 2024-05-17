package com.daroyad.daroyad.views.pages.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.daroyad.daroyad.R
import com.daroyad.daroyad.core.nav.PagesRouteEnum

@Composable
fun OnboardingPage(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    var currentPage by remember { mutableIntStateOf(3) }
    var indicatorPosition by remember { mutableFloatStateOf(0.0f) }

    Column(
        modifier = Modifier.pointerInput(Unit) {
            detectHorizontalDragGestures(
                onHorizontalDrag = { _, dragAmount ->
                    indicatorPosition = dragAmount
                },
                onDragEnd = {
                    if (indicatorPosition > 0 && currentPage <= 2) {
                        currentPage++
                    }

                    if (indicatorPosition < 0 && currentPage >= 1) {
                        currentPage--
                    }
                },
            )
        },
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Box {
            Image(
                painter = painterResource(
                    id = R.drawable.onboarding_background,
                ),
                contentDescription = "onboarding_background",
            )
            Column(
                modifier = modifier.padding(
                    start = 15.0.dp,
                    top = 60.0.dp,
                    end = 15.0.dp,
                ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(
                        id = when (currentPage) {
                            0 -> R.string.onboarding_title_4
                            1 -> R.string.onboarding_title_3
                            2 -> R.string.onboarding_title_2
                            3 -> R.string.onboarding_title_1
                            else -> throw IllegalArgumentException("Unknown page number: $currentPage")
                        },
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
                        id = when (currentPage) {
                            0 -> R.string.onboarding_description_4
                            1 -> R.string.onboarding_description_3
                            2 -> R.string.onboarding_description_2
                            3 -> R.string.onboarding_description_1
                            else -> throw IllegalArgumentException("Unknown page number: $currentPage")
                        },
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
                        textAlign = TextAlign.Center,
                    ),
                    lineHeight = 24.0.sp,
                )
            }
        }
        Box(
            contentAlignment = Alignment.BottomEnd,
        ) {
            Image(
                painter = painterResource(
                    id = when (currentPage) {
                        0 -> R.drawable.onboarding_4
                        1 -> R.drawable.onboarding_3
                        2 -> R.drawable.onboarding_2
                        3 -> R.drawable.onboarding_1
                        else -> throw IllegalArgumentException("Unknown page number: $currentPage")
                    },
                ),
                contentDescription = "onboarding",
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if (currentPage == 0) {
                    Button(
                        onClick = {
                            navHostController.navigate(PagesRouteEnum.MAIN.route) {
                                popUpTo(PagesRouteEnum.ONBOARDING.route) {
                                    inclusive = true
                                }
                            }
                        },
                        modifier = Modifier
                            .padding(
                                end = 20.0.dp,
                                bottom = 27.0.dp,
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2D89FF),
                        ),
                    ) {
                        Text(
                            text = stringResource(
                                id = R.string.login,
                            ),
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
                    }
                }
                SmoothPageIndicator(
                    numPages = 4,
                    currentPage = currentPage,
                )
            }
        }
    }
}
