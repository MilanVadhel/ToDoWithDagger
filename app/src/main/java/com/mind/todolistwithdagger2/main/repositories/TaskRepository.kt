package com.mind.todolistwithdagger2.main.repositories

import com.mind.todolistwithdagger2.main.database.entity.Task

interface TaskRepository {

    fun addTask(task: Task)
    fun getTask() : List<Task>
    fun addToArchive(archivedTaskId: Int)
    fun getArchivedTask(): List<Task>
}