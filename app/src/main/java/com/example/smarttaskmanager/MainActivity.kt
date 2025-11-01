package com.example.smarttaskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.smarttaskmanager.data.database.TaskDatabase
import com.example.smarttaskmanager.data.model.Task
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = TaskDatabase.getDatabase(this)
        val dao = db.taskDao()

        lifecycleScope.launch {
            // Insert temporary task
            dao.insertTask(Task(title = "Test Task", description = "Testing Room DB", date = System.currentTimeMillis()))

            // Fetch and print all tasks
            dao.getAllTasks().collect { tasks ->
                println("✅ Task List: $tasks")
            }
        }

        setContent {
            // Compose UI will come in next modules
        }
    }
}
