package com.jay.businessaccmgmt.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jay.businessaccmgmt.data.RestaurantRepository
import com.jay.businessaccmgmt.data.local.ProductEntity
import com.jay.businessaccmgmt.data.model.InventoryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InventoryViewModel  @Inject constructor(private val repository: RestaurantRepository) : ViewModel() {

    private val _inventoryItems = MutableStateFlow<List<InventoryItem>>(emptyList())

    val inventoryItems: StateFlow<List<InventoryItem>> = _inventoryItems



    init {
        loadInventoryItems()
    }

    private fun loadInventoryItems() {
        viewModelScope.launch {
            repository.getInventoryItems().collect { items ->
                _inventoryItems.value = items
            }
        }
    }




}