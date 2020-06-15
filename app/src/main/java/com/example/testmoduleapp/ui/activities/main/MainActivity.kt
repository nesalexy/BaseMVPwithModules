package com.example.testmoduleapp.ui.activities.main

import android.os.Bundle
import butterknife.ButterKnife
import com.example.testmoduleapp.App
import com.example.testmoduleapp.R
import com.example.testmoduleapp.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(),
    MainView {

    @Inject
    lateinit var mainPresenter: MainPresenter;

    override fun onCreate(savedInstanceState: Bundle?) {
        // dagger
        App.appComponent.inject(activity = this@MainActivity)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUnBinder(ButterKnife.bind(this));

        // init view
        mainPresenter.mainView = this


        setUp()
    }

    override fun setUp() {
        mainPresenter.getUser()
    }
}
