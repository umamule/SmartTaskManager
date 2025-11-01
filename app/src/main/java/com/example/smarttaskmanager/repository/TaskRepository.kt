package com.example.smarttaskmanager.repository

import com.example.smarttaskmanager.data.model.Task
import com.example.smarttaskmanager.data.dao.TaskDao
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {

    // ✅ Get all tasks as Flow (auto-updates UI on change)
    val allTasks: Flow<List<Task>> = taskDao.getAllTasks()

    // ✅ Insert new task
    suspend fun insertTask(task: Task) {
        taskDao.insertTask(task)
    }

    // ✅ Update existing task
    suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }

    // ✅ Delete single task
    suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }

    // ✅ Delete all tasks
    suspend fun deleteAllTasks() {
        taskDao.deleteAllTasks()
    }
}
