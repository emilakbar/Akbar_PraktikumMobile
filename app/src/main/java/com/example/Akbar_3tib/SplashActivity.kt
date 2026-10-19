package com.example.Akbar_3tib

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val splashDuration = 1500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({

            val preferences = getSharedPreferences(
                "LoginSession",
                MODE_PRIVATE
            )

            val isLoggedIn = preferences.getBoolean(
                "isLoggedIn",
                false
            )

            val destination = if (isLoggedIn) {
                BaseActivity::class.java
            } else {
                LoginActivity::class.java
            }

            val intent = Intent(this, destination)
            startActivity(intent)
            finish()

        }, splashDuration)
    }
}
