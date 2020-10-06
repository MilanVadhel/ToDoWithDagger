package com.mind.todolistwithdagger2.main.repositories

import com.mind.todolistwithdagger2.main.database.dao.TaskDao
import com.mind.todolistwithdagger2.main.database.entity.Task

class TaskRepositoryImpl(val taskDao: TaskDao) : TaskRepository {

    override fun addTask(task: Task) {
        taskDao.addTask(task)
    }


    override fun getTask(): List<Task> {
        return taskDao.getTasks()
    }

    override fun addToArchive(archivedTaskId: Int) {
        taskDao.addToArchive(archivedTaskId)
    }

    override fun getArchivedTask(): List<Task> {
        return taskDao.getArchivedTasks()
    }
}