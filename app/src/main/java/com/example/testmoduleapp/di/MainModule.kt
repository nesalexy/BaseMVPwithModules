package com.example.testmoduleapp.di

import com.example.testmoduleapp.ui.activities.main.MainPresenter
import com.example.utilities.networks.NetworkProvider
import dagger.Module
import dagger.Provides

@Module
class MainModule{

    @Provides
    fun getMainPresenter(networkProvider: NetworkProvider): MainPresenter {
        return MainPresenter(networkProvider)
    }

}