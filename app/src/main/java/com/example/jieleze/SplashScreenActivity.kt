package com.example.jieleze

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : Activity() {  // Use Activity instead of AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Show splash screen for 3 seconds before transitioning to MainActivity
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // Close the SplashScreenActivity
        }, 3000)  // 3 seconds delay
    }
}
