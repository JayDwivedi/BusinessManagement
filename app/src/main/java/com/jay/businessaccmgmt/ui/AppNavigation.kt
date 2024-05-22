package com.jay.businessaccmgmt.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jay.businessaccmgmt.ui.screens.InventoryScreen
import com.jay.businessaccmgmt.ui.screens.ProductScreen
import com.jay.businessaccmgmt.ui.screens.SignInScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    BackHandler {
        navController.popBackStack()
    }

    NavHost(navController = navController, startDestination = "signInScreen") {
        composable("signInScreen") {
            SignInScreen(navController = navController)
        }
        composable("inventoryScreen") {
            InventoryScreen()
        }
        composable("productScreen") {
            ProductScreen()
        }
        // Add other destinations as needed
    }
}
