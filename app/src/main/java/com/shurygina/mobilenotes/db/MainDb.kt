package com.shurygina.mobilenotes.db

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shurygina.mobilenotes.Task

@RequiresApi(Build.VERSION_CODES.O)
@Database(entities = [Task::class], version = 1)
abstract class MainDb: RoomDatabase() {
    abstract fun getDao(): Dao

    companion object {
        fun getDb(context: Context): MainDb {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDb::class.java,
                "mobilenotes.db"
            ).build()
        }
    }
}