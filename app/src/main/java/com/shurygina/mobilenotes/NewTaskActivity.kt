package com.shurygina.mobilenotes

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.annotation.RequiresApi
import com.shurygina.mobilenotes.databinding.AddNewTaskActivityBinding
import com.shurygina.mobilenotes.db.Dao
import com.shurygina.mobilenotes.db.MainDb
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
class NewTaskActivity : AppCompatActivity() {
    lateinit var db: MainDb
    lateinit var dao: Dao
    lateinit var binding: AddNewTaskActivityBinding
    lateinit var parentActivity: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = AddNewTaskActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MainDb.getDb(this)
        dao = db.getDao()

        parentActivity = Intent(this, MainActivity::class.java)
    }

    fun onBackBtnClick(view: View) {
        startActivity(parentActivity)
        finish()
    }

    fun onAddBtnClick(view: View) {
        var title = binding.newTaskDescription.text.toString()
        var priority = binding.prioritySwitch.isChecked

        val task = Task(null, title, priority, null, false)

        Thread {
            dao.insertTask(task)
        }.start()

        startActivity(parentActivity)
        finish()
    }
}