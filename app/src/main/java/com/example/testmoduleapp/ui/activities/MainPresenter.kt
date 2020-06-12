package com.example.testmoduleapp.ui.activities

class MainPresenter(val mainView: MainView) {

    fun getUser() {
        mainView.showLoading()
        if(mainView.isNetworkConnected()) {
            mainView.showMessage("success")

        } else {
            mainView.onError("error")
            mainView.hideLoading()
        }

    }

}