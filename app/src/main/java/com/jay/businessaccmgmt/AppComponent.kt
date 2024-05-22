package com.jay.businessaccmgmt

import com.jay.businessaccmgmt.di.AppModule
import com.jay.businessaccmgmt.di.NetworkModule
import com.jay.businessaccmgmt.di.RepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModule::class])
interface AppComponent {

    // Inject into MyApp (Application class)
    fun inject(application: RestaurantApp)

    // Other inject methods for activities, fragments, etc.
    // e.g., fun inject(activity: MyActivity)
}
