package com.mind.todolistwithdagger2.main.repositories

import com.mind.todolistwithdagger2.main.database.dao.TaskDao
import com.mind.todolistwithdagger2.main.database.entity.Task

class TaskRepositoryImpl(val taskDao: TaskDao) : TaskRepository {


    override fun getTask(): List<Task> {
        return taskDao.getTasks()
    }
}