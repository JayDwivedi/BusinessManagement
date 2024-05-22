package com.jay.businessaccmgmt.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val firebaseAuth: FirebaseAuth) : ViewModel() {

    var signInStatus by mutableStateOf(SignInStatus.INITIAL)
    var errorMessage by mutableStateOf<String?>(null)


    fun signInWithGoogle() {
        // Implement Google sign-in logic here

    }

    fun signInWithEmailAndPassword(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    signInStatus = SignInStatus.SUCCESS
                } else {
                    errorMessage = "Email sign in failed: ${task.exception?.message}"
                }
            }
    }
    enum class SignInStatus {
        INITIAL,
        SUCCESS
    }
}