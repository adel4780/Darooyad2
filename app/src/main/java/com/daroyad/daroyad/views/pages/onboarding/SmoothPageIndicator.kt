package com.daroyad.daroyad.views.pages.onboarding

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Composable
fun SmoothPageIndicator(
    numPages: Int, currentPage: Int, modifier: Modifier = Modifier
) {
    val indicatorPosition = remember {
        Animatable(
            initialValue = currentPage.toFloat(),
        )
    }

    LaunchedEffect(currentPage) {
        indicatorPosition.animateTo(
            targetValue = currentPage.toFloat(),
            animationSpec = tween(durationMillis = 300),
        )
    }

    CompositionLocalProvider(
        LocalLayoutDirection provides LayoutDirection.Rtl,
    ) {
        Row(
            modifier = Modifier
                .padding(
                    end = 20.0.dp,
                    bottom = 30.0.dp,
                )
                .size(
                    56.0.dp,
                    10.dp,
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            repeat(numPages) { pageIndex ->
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Canvas(
                        modifier = Modifier,
                        onDraw = {
                            drawRoundRect(
                                color =
                                if (pageIndex == indicatorPosition.value.toInt())
                                    Color(0xFF2D89FF)
                                else
                                    Color(0xFFE7ECF3),
                                size = Size(
                                    10.0.dp.toPx(),
                                    10.0.dp.toPx(),
                                ),
                                cornerRadius = CornerRadius(
                                    10.0f,
                                    10.0f,
                                ),
                            )
                        },
                    )
                }
            }
        }
    }
}
