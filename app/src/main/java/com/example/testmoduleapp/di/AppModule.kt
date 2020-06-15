package com.example.testmoduleapp.di

import android.app.Application
import android.content.Context
import com.example.testmoduleapp.ui.activities.main.MainPresenter
import com.example.utilities.networks.NetworkProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app:Application){

    @Provides
    @Singleton
    fun provideContext(): Context = app

}