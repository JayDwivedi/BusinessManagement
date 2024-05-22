package com.jay.businessaccmgmt.ui.viewmodels

// ProductViewModel.kt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jay.businessaccmgmt.data.RestaurantRepository
import com.jay.businessaccmgmt.data.local.ProductEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: RestaurantRepository
) : ViewModel() {

    val products = productRepository.getAllProductData()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    init {
        viewModelScope.launch {
            productRepository.fetchDataAndUpdateDb()
        }
    }

    fun insertProductData(data: ProductEntity) {
        viewModelScope.launch {
            productRepository.insertProductData(data)
        }
    }

}
