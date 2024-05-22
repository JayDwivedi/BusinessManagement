package com.jay.businessaccmgmt.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.jay.businessaccmgmt.data.model.InventoryItem
import com.jay.businessaccmgmt.ui.viewmodels.InventoryViewModel


@Composable
fun InventoryScreen(viewModel: InventoryViewModel = hiltViewModel()) {
    val inventoryItemsState = viewModel.inventoryItems.collectAsState()

    Column {
        Text(text = "Inventory Items:")
        LazyColumn {
            items(inventoryItemsState.value) { item ->
                InventoryItemRow(item)
            }
        }
    }
}
    @Composable
    fun InventoryItemRow(item: InventoryItem) {
        Text(text = "${item.name}: ${item.quantity}")
    }