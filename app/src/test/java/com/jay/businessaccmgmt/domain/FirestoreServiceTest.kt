package com.jay.businessaccmgmt.domain

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.jay.businessaccmgmt.data.model.InventoryItem
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class FirestoreServiceTest {

    @Mock
    private lateinit var firestore: FirebaseFirestore

    private lateinit var firestoreService: FirestoreService

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        firestoreService = FirestoreService(firestore)
    }

    @Test
    fun getInventoryItems_success() = runBlocking {
        // Mock the behavior of Firestore query
        val querySnapshot = mockQuerySnapshot()
        `when`(firestore.collection("inventory").get().await()).thenReturn(querySnapshot)

        // Call the function being tested
        val items = firestoreService.getInventoryItems().toList()

        // Verify the result
        assertEquals(2, items.size) // Assuming there are two items in the mock response
        // Add more assertions based on your test data
    }

    // Function to mock QuerySnapshot
    private fun mockQuerySnapshot(): QuerySnapshot {
        // Mocked InventoryItem objects
        val item1 = InventoryItem("id1", "Item 1", 10, price = 12.0)
        val item2 = InventoryItem("id2", "Item 2", 20, price = 13.0)
        // Mock QuerySnapshot
        val querySnapshot = mock(QuerySnapshot::class.java)
        `when`(querySnapshot.documents).thenReturn(
            listOf(
                mockDocumentSnapshot(item1),
                mockDocumentSnapshot(item2)
            )
        )
        return querySnapshot
    }

    // Function to mock DocumentSnapshot
    private fun mockDocumentSnapshot(item: InventoryItem) = mock(DocumentSnapshot::class.java).apply {
        `when`(toObject(InventoryItem::class.java)).thenReturn(item)
    }
}
