package com.jay.businessaccmgmt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import com.jay.businessaccmgmt.ui.AppNavigation
import com.jay.businessaccmgmt.ui.screens.InventoryScreen
import com.jay.businessaccmgmt.ui.screens.SignInScreen
import com.jay.businessaccmgmt.ui.theme.BusinessAccMgmtTheme
import com.jay.businessaccmgmt.ui.viewmodels.InventoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
companion object{
    private const val RC_SIGN_IN = 9001
}

    private lateinit var googleSignInClient: GoogleApiClient
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessAccMgmtTheme {

                AppNavigation()

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessAccMgmtTheme {
       AppNavigation()
    }
}