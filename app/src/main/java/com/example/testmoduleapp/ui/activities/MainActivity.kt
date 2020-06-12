package com.example.testmoduleapp.ui.activities

import android.os.Bundle
import android.util.Log
import butterknife.ButterKnife
import com.example.testmoduleapp.R
import com.example.testmoduleapp.ui.base.BaseActivity

class MainActivity : BaseActivity(), MainView {

    val TAG = "MainActivity";
    lateinit var mainPresenter: MainPresenter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUnBinder(ButterKnife.bind(this));

        mainPresenter = MainPresenter(this)

        setUp()
    }

    override fun setUp() {
        mainPresenter.getUser()
    }
}
