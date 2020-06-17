package com.example.testmoduleapp.di.modules

import com.example.testmoduleapp.App
import com.example.testmoduleapp.ui.activities.main.MainPresenter
import com.example.utilities.di.UtilsModule
import com.example.utilities.networks.INetworkProvider
import com.example.utilities.networks.NetworkProvider
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun getMainPresenter(networkProvider: INetworkProvider): MainPresenter {
        return MainPresenter(networkProvider)
    }

}