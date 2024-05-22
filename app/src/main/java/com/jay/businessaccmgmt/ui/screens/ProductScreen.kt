package com.jay.businessaccmgmt.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.jay.businessaccmgmt.ui.theme.BusinessAccMgmtTheme
import com.jay.businessaccmgmt.ui.viewmodels.ProductViewModel


@Composable
fun ProductScreen(viewModel: ProductViewModel = hiltViewModel()) {

    val data by viewModel.products.collectAsState(initial = emptyList())

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            LazyColumn {
                items(data) { product ->
                    Text(text = product.title)
                }
            }
            Button(onClick = { /* Perform action */ }) {
                Text(text = "Fetch Data")
            }
        }
    }



}
@Preview(showBackground = true)
@Composable
fun PreviewProductScreen() {
    BusinessAccMgmtTheme {
        ProductScreen(viewModel = hiltViewModel())
    }
}