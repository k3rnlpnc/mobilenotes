package com.shurygina.mobilenotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate was started")
    }

    override fun onResume() {
        super.onResume()

        Log.d("MainActivity", "onResume was started")
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart was started")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause was started")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy was started")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop was started")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart was started")
    }
}