package com.jay.businessaccmgmt

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jay.businessaccmgmt.data.local.ProductEntity
import com.jay.businessaccmgmt.data.RestaurantRepository
import com.jay.businessaccmgmt.ui.viewmodels.ProductViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class ProductViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ProductViewModel

    @Mock
    private lateinit var repository: RestaurantRepository

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        viewModel = ProductViewModel(repository)
    }

    @Test
    fun `test products LiveData`() = testScope.runBlockingTest {
        val mockProducts = listOf(
            ProductEntity(
                id = 1,
                title = "Product 1",
                description = "Description 1",
                price = 100.0, // Mock price value
                discountPercentage = 10.0, // Mock discount percentage value
                rating = 4.5, // Mock rating value
                stock = 50, // Mock stock value
                brand = "Brand A", // Mock brand value
                category = "Category A", // Mock category value
                thumbnail = "https://example.com/thumbnail.jpg", // Mock thumbnail URL
                images = listOf(
                    "https://example.com/image1.jpg",
                    "https://example.com/image2.jpg"
                ) // Mock image URLs
            ),
            // Add more ProductEntity objects as needed
        )
        // Given

        `when`(repository.getAllProductData()).thenReturn(flowOf(mockProducts))

        // When
        val products = viewModel.products.first()

        // Then
        assertEquals(mockProducts, products)
    }

    // Add more test cases for other ViewModel functionalities
}
