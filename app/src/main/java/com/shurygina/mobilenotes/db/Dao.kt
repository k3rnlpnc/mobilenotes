package com.shurygina.mobilenotes.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.shurygina.mobilenotes.Task
import kotlinx.coroutines.flow.Flow

@androidx.room.Dao
interface Dao {

    @Insert
    fun insertTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<Task>>
}