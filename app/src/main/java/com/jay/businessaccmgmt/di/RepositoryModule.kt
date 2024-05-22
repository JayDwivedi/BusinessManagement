package com.jay.businessaccmgmt.di

import com.jay.businessaccmgmt.data.RestaurantRepository
import com.jay.businessaccmgmt.data.local.dao.ProductDao
import com.jay.businessaccmgmt.data.remote.ApiService
import com.jay.businessaccmgmt.domain.FirestoreService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRestaurantRepository(firestoreService: FirestoreService, apiService: ApiService, productDao: ProductDao): RestaurantRepository {
        return RestaurantRepository(firestoreService,apiService, productDao)
    }
}