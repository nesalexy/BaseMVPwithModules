package com.example.testmoduleapp.di

import android.app.Application
import com.example.testmoduleapp.App
import com.example.testmoduleapp.di.modules.ActivityBindingModule
import com.example.testmoduleapp.di.modules.MainModule
import com.example.testmoduleapp.ui.activities.main.MainActivity
import com.example.utilities.di.UtilsComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(
            dependencies = [UtilsComponent::class],
            modules = [
                    AndroidInjectionModule::class,
                    ActivityBindingModule::class,
                    MainModule::class // test module
            ]
)

@AppScope
interface AppComponent: AndroidInjector<App> {
    // inject to ...
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun utilsComponent(utilsComponent: UtilsComponent): AppComponent.Builder

        fun build(): AppComponent
    }

    fun inject(activity: MainActivity)
}

//@Component(modules = [AppModule::class, UtilsModule::class, MainModule::class])
//
//@Singleton
//interface AppComponent {
//    // inject to ...
//
//    fun inject(activity: MainActivity)
//}