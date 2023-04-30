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
import com.shurygina.mobilenotes.db.DataBaseManager
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {
    val dbManager = DataBaseManager(this)
    lateinit var binding: ActivityMainBinding
    lateinit var tasks: ArrayList<String>

    val dateFormat = DateTimeFormatter.ofPattern("d MMMM")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dbManager.openDb()

        initStartActivity()
    }

    private fun initStartActivity() {
        binding.currentDate.text = LocalDate.now().format(dateFormat)
        tasks = dbManager.read()

        if (tasks.isNotEmpty()) {
            binding.task.text = tasks[tasks.size - 1]
            binding.task.visibility = View.VISIBLE
        }
    }

    fun onAddTaskClick(view: View) {
        val newTaskIntent = Intent(this, NewTaskActivity::class.java)
        startActivity(newTaskIntent)
        finish()
    }

    fun onWindowClick(view: View) {
        binding.root.clearFocus()
    }

    override fun onDestroy() {
        super.onDestroy()
        dbManager.close()
    }
}