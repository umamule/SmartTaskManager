package com.example.smarttaskmanager.repository

import com.example.smarttaskmanager.data.dao.TaskDao
import com.example.smarttaskmanager.data.model.Task
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {

    val allTasks: Flow<List<Task>> = taskDao.getAllTasks()

    suspend fun insert(task: Task) {
        taskDao.insertTask(task)
    }

    suspend fun delete(task: Task) {
        taskDao.deleteTask(task)
    }

    suspend fun update(task: Task) {
        taskDao.updateTask(task)
    }
}
