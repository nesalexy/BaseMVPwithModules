package com.example.testmoduleapp.ui.activities.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.testmoduleapp.R
import com.example.testmoduleapp.ui.activities.main.MainActivity

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT = 2000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val i = Intent(this@SplashActivity, MainActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(i)
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }
}