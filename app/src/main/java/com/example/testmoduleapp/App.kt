package com.example.testmoduleapp

import android.app.Application
import com.example.testmoduleapp.di.AppComponent
import com.example.testmoduleapp.di.DaggerAppComponent
import com.example.utilities.di.DaggerUtilsComponent
import com.example.utilities.di.UtilsComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .utilsComponent(provideUtilsComponent())
            .build()
    }

    private fun provideUtilsComponent(): UtilsComponent {
        return DaggerUtilsComponent
            .builder()
            .application(this)
            .build()
    }
}