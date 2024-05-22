package com.jay.businessaccmgmt

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jay.businessaccmgmt.data.RestaurantRepository
import com.jay.businessaccmgmt.data.local.ProductEntity
import com.jay.businessaccmgmt.data.local.dao.ProductDao
import com.jay.businessaccmgmt.data.remote.ApiResponse
import com.jay.businessaccmgmt.data.remote.ApiService
import com.jay.businessaccmgmt.data.remote.Product
import com.jay.businessaccmgmt.domain.FirestoreService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class RestaurantRepositoryTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var repository: RestaurantRepository

    @Mock
    private lateinit var firestoreService: FirestoreService

    @Mock
    private lateinit var apiService: ApiService

    @Mock
    private lateinit var productDao: ProductDao

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        repository = RestaurantRepository(firestoreService, apiService, productDao)
    }

    @Test
    fun `test fetch data and update db`() = testScope.runBlockingTest {
        // Given
        // Create a mock ApiService
        val apiService = Mockito.mock(ApiService::class.java)

// Define a mock response object
        val mockResponse = ApiResponse(
            products = listOf(
                Product(
                    id = 1,
                    title = "Product 1",
                    description = "Description 1",
                    price = 100.0,
                    discountPercentage = 10.0,
                    rating = 4.5,
                    stock = 50,
                    brand = "Brand A",
                    category = "Category A",
                    thumbnail = "https://example.com/thumbnail.jpg",
                    images = listOf(
                        "https://example.com/image1.jpg",
                        "https://example.com/image2.jpg"
                    )
                ),
                // Add more Product objects as needed
            )
        )

// Define the behavior of the mock ApiService
        Mockito.`when`(apiService.getProducts()).thenReturn(mockResponse)


        // When
        repository.fetchDataAndUpdateDb()

        // Then
        // Verify that the data is inserted into the database correctly
        // Use a test database or mock ProductDao to verify the insertion
    }

    // Add more test cases for other Repository functionalities
}
