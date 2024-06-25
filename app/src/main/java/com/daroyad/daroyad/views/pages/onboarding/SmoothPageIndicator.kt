import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

val BackgroundColorKey = SemanticsPropertyKey<Color>("BackgroundColor")
var SemanticsPropertyReceiver.backgroundColor by BackgroundColorKey

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
                .padding(end = 20.dp, bottom = 30.dp)
                .size(56.dp, 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            repeat(numPages) { pageIndex ->
                val color = if (pageIndex == indicatorPosition.value.toInt())
                    Color(0xFF2D89FF)
                else
                    Color(0xFFE7ECF3)
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .testTag("PageIndicator_$pageIndex")
                        .size(10.dp)
                ) {
                    Canvas(
                        modifier = Modifier,
                        onDraw = {
                            drawRoundRect(
                                color = color,
                                size = Size(10.dp.toPx(), 10.dp.toPx()),
                                cornerRadius = CornerRadius(10f, 10f),
                            )
                        },
                    )
                }
            }
        }
    }
}



