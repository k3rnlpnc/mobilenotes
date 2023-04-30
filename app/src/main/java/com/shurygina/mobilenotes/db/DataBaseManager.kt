package com.shurygina.mobilenotes.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class DataBaseManager(context: Context) {
    val dbHelper = DataBaseHelper(context)
    var db: SQLiteDatabase? = null

    val dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")

    fun openDb() {
        db = dbHelper.writableDatabase
    }

    fun close() {
        dbHelper.close()
    }

    fun insert(title: String, priority: Boolean, isDone: Boolean, creationDate: LocalDateTime) {
        val values = ContentValues().apply {
            put(Task.COLUMN_NAME_TITLE, title)
            put(Task.COLUMN_NAME_PRIORITY, priority)
            put(Task.COLUMN_NAME_IS_DONE, isDone)
            put(Task.COLUMN_NAME_CREATION_DATE, creationDate.format(dateTimeFormat))
        }

        db?.insert(Task.TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun read(): ArrayList<String> {
        val data = ArrayList<String>()
        val cursor = db?.query(
            Task.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null
        )

        with (cursor) {
            while (this?.moveToNext()!!) {
                val string = cursor?.getString(cursor.getColumnIndex(Task.COLUMN_NAME_TITLE))
                if (string != null) {
                    data.add(string)
                }
            }
        }

        cursor?.close()

        return data
    }
}