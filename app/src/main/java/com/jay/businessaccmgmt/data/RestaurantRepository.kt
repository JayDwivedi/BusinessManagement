package com.jay.businessaccmgmt.data

import com.jay.businessaccmgmt.data.local.ProductEntity
import com.jay.businessaccmgmt.data.local.dao.ProductDao
import com.jay.businessaccmgmt.data.remote.ApiService
import com.jay.businessaccmgmt.domain.FirestoreService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RestaurantRepository @Inject constructor(private val firestoreService: FirestoreService, private val apiService: ApiService, private val productDao: ProductDao) {

    fun getInventoryItems() = firestoreService.getInventoryItems()




    suspend fun fetchDataAndUpdateDb() {
        val apiResponse = apiService.getProducts()
        val productEntities = apiResponse.products.map { product ->
            ProductEntity(
                id = product.id,
                title = product.title,
                description = product.description,
                price = product.price,
                discountPercentage = product.discountPercentage,
                rating = product.rating,
                stock = product.stock,
                brand = product.brand,
                category = product.category,
                thumbnail = product.thumbnail,
                images = product.images
            )
        }

        productDao.insertDataList(productEntities)
    }

    fun getAllProductData(): Flow<List<ProductEntity>> {
        return productDao.getAllData()
    }

    suspend fun insertProductData(data: ProductEntity) {
        productDao.insertData(data)
    }

}