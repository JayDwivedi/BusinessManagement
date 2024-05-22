package com.jay.businessaccmgmt.ui

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class AppNavigationTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: TestNavHostController


    @Before
    fun setUp() {
        hiltRule.inject()
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            AppNavigation(navController)
        }
    }

    @Test
    fun testSignInScreenNavigation() {


        // Check if the SignInScreen is displayed
        composeTestRule.onNodeWithText("Sign in with Email").assertIsDisplayed()
    }

    @Test
    fun testNavigateToInventoryScreen() {


        // Navigate to InventoryScreen
        composeTestRule.onNodeWithText("Sign in with Email").performClick()
        composeTestRule.onNodeWithText("Inventory Screen").assertIsDisplayed()
    }

    @Test
    fun testNavigateToProductScreen() {

        // Navigate to ProductScreen
        composeTestRule.onNodeWithText("Sign in with Email").performClick()
        composeTestRule.onNodeWithText("Product Screen").assertIsDisplayed()
    }
}
