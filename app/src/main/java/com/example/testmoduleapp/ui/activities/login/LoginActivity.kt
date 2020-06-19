package com.example.testmoduleapp.ui.activities.login


import android.os.Bundle

import com.example.testmoduleapp.R
import com.example.testmoduleapp.ui.base.BaseActivity


class LoginActivity : BaseActivity(), LoginView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

    }

    override fun setUp() {
        TODO("Not yet implemented")
    }

}
