package com.shurygina.mobilenotes.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context):
    SQLiteOpenHelper(context, Task.DATABASE_NAME, null, Task.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(Task.CREATE_TABLE_TASKS)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(Task.DELETE_TABLE_TASKS)
        onCreate(db)
    }
}