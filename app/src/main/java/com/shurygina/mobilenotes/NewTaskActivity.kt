package com.shurygina.mobilenotes

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.annotation.RequiresApi
import com.shurygina.mobilenotes.databinding.ActivityMainBinding
import com.shurygina.mobilenotes.databinding.AddNewTaskActivityBinding
import com.shurygina.mobilenotes.db.DataBaseManager
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
class NewTaskActivity : AppCompatActivity() {
    val dbManager = DataBaseManager(this)
    lateinit var binding: AddNewTaskActivityBinding
    lateinit var parentActivity: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = AddNewTaskActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbManager.openDb()
        parentActivity = Intent(this, MainActivity::class.java)
    }

    fun onBackBtnClick(view: View) {
        startActivity(parentActivity)
        finish()
    }

    fun onAddBtnClick(view: View) {
        var title = binding.newTaskDescription.text.toString()
        var priority = binding.prioritySwitch.isChecked

        dbManager.insert(title, priority, false, LocalDateTime.now())

        startActivity(parentActivity)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        dbManager.close()
    }
}