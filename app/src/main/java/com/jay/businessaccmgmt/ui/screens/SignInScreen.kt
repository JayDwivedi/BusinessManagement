package com.jay.businessaccmgmt.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.jay.businessaccmgmt.ui.viewmodels.AuthViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun SignInScreen(
    navController: NavController,
    authViewModel: AuthViewModel = hiltViewModel()
) {
    // Create a mutable state to track loading state
    val isLoading = mutableStateOf(false)
    // Inside your sign-in screen composable
    LaunchedEffect(authViewModel.signInStatus) {
        when (authViewModel.signInStatus) {
            AuthViewModel.SignInStatus.SUCCESS -> {
                navController.navigate("ProductScreen")
            }

            else -> {}
        }
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                isLoading.value =true
                authViewModel.signInWithEmailAndPassword(
                    "jkdwivedi@test.com",
                    "123456"
                )
            },
                enabled = !isLoading.value
            ) {
                if (isLoading.value) {
                    // Show loading indicator if loading
                    CircularProgressIndicator()
                } else {
                    // Show sign-in text if not loading
                    Text(text = "Sign in with Email")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    // Perform sign-in with Google
                    authViewModel.signInWithGoogle()
                },
                // Disable the button when loading
                enabled = !isLoading.value
            ) {
                if (isLoading.value) {
                    // Show loading indicator if loading
                    CircularProgressIndicator()
                } else {
                    // Show sign-in text if not loading
                    Text(text = "Sign in with Google")
                }
            }
        }
    }
}


