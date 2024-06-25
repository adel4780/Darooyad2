import android.content.Context
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.test.core.app.ApplicationProvider
import com.daroyad.daroyad.R
import com.daroyad.daroyad.views.pages.onboarding.OnboardingPage
import org.junit.Rule
import org.junit.Test

class OnboardingPageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testOnboardingPage() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        lateinit var navController: NavHostController

        composeTestRule.setContent {
            navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "onboarding"
            ) {
                composable("onboarding") {
                    OnboardingPage(navHostController = navController)
                }
                composable("main") {
                    // Main screen content
                }
            }
        }

        // Verify initial page title
        composeTestRule.onNodeWithText(context.getString(R.string.onboarding_title_1))
            .assertIsDisplayed()

        // Simulate horizontal drag gesture to switch to the next page
        composeTestRule.onRoot().performTouchInput {
            swipeLeft()
        }

        // Verify the title of the second page
        composeTestRule.onNodeWithText(context.getString(R.string.onboarding_title_2))
            .assertIsDisplayed()

        // Simulate horizontal drag gesture to switch to the next page
        composeTestRule.onRoot().performTouchInput {
            swipeLeft()
        }

        // Verify the title of the third page
        composeTestRule.onNodeWithText(context.getString(R.string.onboarding_title_3))
            .assertIsDisplayed()

        // Simulate horizontal drag gesture to switch to the next page
        composeTestRule.onRoot().performTouchInput {
            swipeLeft()
        }

        // Verify the title of the fourth page
        composeTestRule.onNodeWithText(context.getString(R.string.onboarding_title_4))
            .assertIsDisplayed()

        // Verify the login button is displayed on the last page
        composeTestRule.onNodeWithText(context.getString(R.string.login))
            .assertIsDisplayed()
            .performClick()

        // Verify navigation to main page
        composeTestRule.runOnIdle {
            assert(navController.currentBackStackEntry?.destination?.route == "main")
        }
    }
}
