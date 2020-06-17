package com.example.utilities.di

import android.app.Application
import android.content.Context
import com.example.utilities.networks.INetworkProvider
import com.example.utilities.networks.NetworkProvider
import com.example.utilities.resources.IResourceProvider
import com.example.utilities.resources.ResourceProvider
import dagger.*

//@Module
//class UtilsModule {
//
//    @Provides
//    fun getNetworkProvider(context: Context): NetworkProvider {
//        return NetworkProvider(context)
//    }
//
//
//}

@Component(modules = [UtilsModule::class])
interface UtilsComponent {

    fun getResourceProvider() : IResourceProvider
    fun getNetworkProvider(): INetworkProvider

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): UtilsComponent.Builder
        fun build(): UtilsComponent
    }
}

@Module
abstract class UtilsModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun bindResourceProvider(context: Context): IResourceProvider {
            return ResourceProvider(context = context)
        }

        @Provides
        @JvmStatic
        fun bindNetworkProvider(context: Context): INetworkProvider {
            return NetworkProvider(context = context)
        }
    }
}