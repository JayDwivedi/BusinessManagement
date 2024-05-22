package com.jay.businessaccmgmt.ui.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.jay.businessaccmgmt.ui.viewmodels.ProductViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class ProductScreenTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var viewModel: ProductViewModel

    @Before
    fun setUp() {
        hiltRule.inject()

    }

    @Test
    fun testProductScreenDisplays() {
        composeTestRule.setContent {
            ProductScreen()
        }

        // Assuming you have initial data in the ViewModel
        val productTitle = "Sample Product"
        composeTestRule.onNodeWithText(productTitle).assertIsDisplayed()
    }

    @Test
    fun testFetchDataButton() {
        composeTestRule.setContent {
            ProductScreen()
        }

        composeTestRule.onNodeWithText("Fetch Data").performClick()

        // Check if the data fetching logic is triggered and UI is updated accordingly
        // You might need to mock the ViewModel for this
    }
}
