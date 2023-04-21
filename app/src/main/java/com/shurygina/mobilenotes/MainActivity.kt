package com.shurygina.mobilenotes

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.shurygina.mobilenotes.databinding.ActivityMainBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val dateFormat = DateTimeFormatter.ofPattern("d MMMM")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initStartActivity()
    }

    private fun initStartActivity() {
        binding.currentDate.text = LocalDate.now().format(dateFormat)
    }

    fun onAddTaskClick(view: View) {
        val newTaskIntent = Intent(this, NewTaskActivity::class.java)
        startActivity(newTaskIntent)
        finish()
    }

    fun onWindowClick(view: View) {
        binding.root.clearFocus()
    }

}