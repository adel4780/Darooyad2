import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class SmoothPageIndicatorTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSmoothPageIndicator() {
        val numPages = 4
        val currentPage = mutableStateOf(0)

        composeTestRule.setContent {
            val currentPageState = remember { currentPage }
            SmoothPageIndicator(numPages = numPages, currentPage = currentPageState.value)
        }

        // Verify initial state
        verifyPageIndicator(0, numPages)

        // Change to the second page
        composeTestRule.runOnIdle {
            currentPage.value = 1
        }
        verifyPageIndicator(1, numPages)

        // Change to the third page
        composeTestRule.runOnIdle {
            currentPage.value = 2
        }
        verifyPageIndicator(2, numPages)

        // Change to the fourth page
        composeTestRule.runOnIdle {
            currentPage.value = 3
        }
        verifyPageIndicator(3, numPages)
    }

    private fun verifyPageIndicator(selectedPage: Int, numPages: Int) {
        // Verify the number of indicators
        (0 until numPages).forEach { pageIndex ->
            val indicatorTag = "PageIndicator_$pageIndex"
            composeTestRule.onNodeWithTag(indicatorTag)
                .assertExists()
                .assertColor(if (pageIndex == selectedPage) Color(0xFF2D89FF) else Color(0xFFE7ECF3))
        }
    }

    private fun SemanticsNodeInteraction.assertColor(expectedColor: Color) {
        captureToImage().assertContainsColor(expectedColor)
    }

    private fun ImageBitmap.assertContainsColor(expectedColor: Color) {
        val buffer = IntArray(width * height)
        readPixels(buffer)
        assert(buffer.contains(expectedColor.toArgb())) { "Image does not contain the expected color $expectedColor" }
    }

    private fun Color.toArgb(): Int {
        return android.graphics.Color.argb(
            (alpha * 255).toInt(),
            (red * 255).toInt(),
            (green * 255).toInt(),
            (blue * 255).toInt()
        )
    }
}
