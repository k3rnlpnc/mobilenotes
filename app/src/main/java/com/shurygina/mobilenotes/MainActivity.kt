package com.shurygina.mobilenotes

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.lifecycle.asLiveData
import com.shurygina.mobilenotes.databinding.ActivityMainBinding
import com.shurygina.mobilenotes.db.Dao
import com.shurygina.mobilenotes.db.MainDb
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {
    lateinit var db: MainDb
    lateinit var dao: Dao

    lateinit var binding: ActivityMainBinding

    val dateFormat = DateTimeFormatter.ofPattern("d MMMM")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MainDb.getDb(this)
        dao = db.getDao()

        try {
            initStartActivity()
        } catch (e: Exception) {
            println(e.message)
        }
    }

    private fun initStartActivity() {
        binding.currentDate.text = LocalDate.now().format(dateFormat)
        dao.getAllTasks().asLiveData().observe(this) {
            binding.taskList.adapter = TaskAdapter(this, it)
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
}