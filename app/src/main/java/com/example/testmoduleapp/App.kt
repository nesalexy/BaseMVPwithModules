package com.example.testmoduleapp

import android.app.Application
import com.example.testmoduleapp.di.AppComponent
import com.example.testmoduleapp.di.DaggerAppComponent

class App : Application() {

    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
            .build()
    }
}