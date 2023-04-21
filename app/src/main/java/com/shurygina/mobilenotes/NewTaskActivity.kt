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

@RequiresApi(Build.VERSION_CODES.O)
class NewTaskActivity : AppCompatActivity() {
    lateinit var binding: AddNewTaskActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = AddNewTaskActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onBackBtnClick(view: View) {
        val parentActivity = Intent(this, MainActivity::class.java)
        startActivity(parentActivity)
        finish()
    }
}