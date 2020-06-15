package com.example.testmoduleapp.ui.activities.main

import com.example.utilities.networks.NetworkProvider

class MainPresenter(val networkProvider: NetworkProvider) {

    lateinit var mainView: MainView

    fun getUser() {
        mainView.showLoading()
        if(networkProvider.isNetwork()) {
            mainView.showMessage("success")
            mainView.hideLoading()
        } else {
            mainView.onError("error")
            mainView.hideLoading()
        }

    }

}