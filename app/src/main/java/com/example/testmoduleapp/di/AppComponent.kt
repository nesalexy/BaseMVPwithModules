package com.example.testmoduleapp.di

import android.app.Application
import com.example.testmoduleapp.ui.activities.main.MainActivity
import com.example.utilities.di.UtilsModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

//@Component(modules = [], dependencies = [UtilsModule::class])
//
//interface AppComponent {
//    // inject to ...
//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        fun application(application: Application): AppComponent.Builder
//
//        fun utilsComponent(utilsComponent: UtilsModule): AppComponent.Builder
//
//        fun build(): AppComponent
//    }
//
//    fun inject(activity: MainActivity)
//}

@Component(modules = [AppModule::class, UtilsModule::class, MainModule::class])

@Singleton
interface AppComponent {
    // inject to ...

    fun inject(activity: MainActivity)
}