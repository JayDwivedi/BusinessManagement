package com.jay.businessaccmgmt.domain

import com.google.firebase.firestore.FirebaseFirestore
import com.jay.businessaccmgmt.data.model.InventoryItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirestoreService @Inject constructor(private val firestore: FirebaseFirestore) {

    fun getInventoryItems(): Flow<List<InventoryItem>> = flow {
        val snapshot = firestore.collection("inventory").get().await()
        val items = snapshot.documents.mapNotNull { doc ->
            doc.toObject(InventoryItem::class.java)
        }
        emit(items)
    }
}