package com.example.smarttaskmanager.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.smarttaskmanager.data.model.Task
import com.example.smarttaskmanager.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(
    application: Application,
    private val repository: TaskRepository
) : AndroidViewModel(application) {

    // Expose tasks as LiveData (Flow -> LiveData conversion)
    val allTasks = repository.allTasks.asLiveData()

    // Insert a new task
    fun insert(task: Task) = viewModelScope.launch {
        repository.insert(task)
    }

    // Update an existing task
    fun update(task: Task) = viewModelScope.launch {
        repository.update(task)
    }

    // Delete a specific task
    fun delete(task: Task) = viewModelScope.launch {
        repository.delete(task)
    }

    // Delete all tasks
    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }
}
