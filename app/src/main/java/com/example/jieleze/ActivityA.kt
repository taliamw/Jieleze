package com.example.jieleze
import android.app.Activity
import android.os.Bundle
class ActivityA: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
    }
}