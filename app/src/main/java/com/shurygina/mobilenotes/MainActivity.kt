package com.shurygina.mobilenotes

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
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {
    lateinit var tasks: List<TextInputEditText>
    lateinit var currentDate: TextView

    val dateFormat = DateTimeFormatter.ofPattern("d MMMM")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)

        initStartActivity()
    }

    private fun initStartActivity() {
        currentDate = findViewById<TextView>(R.id.currentDate)
        currentDate.text = LocalDate.now().format(dateFormat)
    }

    fun onAddTaskClick(view: View) {
    }

    fun onWindowClick(view: View) {
        findViewById<ConstraintLayout>(R.id.mainActivity).clearFocus()
    }

}