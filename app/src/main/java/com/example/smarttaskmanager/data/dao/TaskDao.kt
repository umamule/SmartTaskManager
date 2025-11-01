package com.example.smarttaskmanager.data.dao

import androidx.room.*
import com.example.smarttaskmanager.data.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    // Insert or Update
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    // Delete
    @Delete
    suspend fun deleteTask(task: Task)

    // Update task manually
    @Update
    suspend fun updateTask(task: Task)

    // Get all tasks (Flow for real-time UI updates)
    @Query("SELECT * FROM tasks ORDER BY date ASC")
    fun getAllTasks(): Flow<List<Task>>
}
