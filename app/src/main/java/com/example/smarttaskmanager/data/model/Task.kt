package com.example.smarttaskmanager.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,                // ✅ This fixes “Cannot resolve symbol 'id'”
    val title: String,
    val description: String,
    val category: String,
    val dueDate: String,
    val isCompleted: Boolean = false
)
