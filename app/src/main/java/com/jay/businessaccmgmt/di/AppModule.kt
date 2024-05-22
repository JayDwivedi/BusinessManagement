package com.jay.businessaccmgmt.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.jay.businessaccmgmt.data.RestaurantRepository
import com.jay.businessaccmgmt.data.local.BusinessDatabase
import com.jay.businessaccmgmt.data.local.dao.ProductDao
import com.jay.businessaccmgmt.data.remote.ApiService
import com.jay.businessaccmgmt.domain.FirestoreService
import com.jay.businessaccmgmt.ui.viewmodels.AuthViewModel
import com.jay.businessaccmgmt.ui.viewmodels.InventoryViewModel
import com.jay.businessaccmgmt.ui.viewmodels.ProductViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    fun provideAuthViewModel(firebaseAuth: FirebaseAuth): AuthViewModel {
        return AuthViewModel(firebaseAuth)
    }

    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    fun provideFirestoreService(firestore: FirebaseFirestore): FirestoreService {
        return FirestoreService(firestore)
    }




    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): BusinessDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            BusinessDatabase::class.java,
            "business_mgmt_db"
        ).build()
    }

    @Provides
      fun provideProductDao(database: BusinessDatabase) = database.ProductDao()


    @Provides
    fun provideInventoryViewModel(repository: RestaurantRepository): InventoryViewModel {
        return InventoryViewModel(repository)
    }

    @Provides
    fun provideProductViewModel(repository: RestaurantRepository)= ProductViewModel(repository)

}