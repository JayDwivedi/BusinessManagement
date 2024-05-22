package com.jay.businessaccmgmt.ui.viewmodels

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject


@HiltAndroidTest
@UninstallModules(AuthViewModel::class)
class AuthViewModelTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var authViewModel: AuthViewModel

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun signInWithEmailAndPassword_validCredentials_success() {
        // Mock successful sign-in response
        // Mock successful sign-in response


        authViewModel.signInWithEmailAndPassword("test@example.com", "password")


    }

    // Write other test cases similarly
}
