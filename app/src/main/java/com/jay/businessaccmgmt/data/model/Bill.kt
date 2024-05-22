package com.jay.businessaccmgmt.data.model

data class Bill(
    val id: String,
    val items: List<InventoryItem>,
    val totalAmount: Double,
    val timestamp: Long
)