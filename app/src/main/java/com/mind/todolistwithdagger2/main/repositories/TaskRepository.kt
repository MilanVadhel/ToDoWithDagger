package com.mind.todolistwithdagger2.main.repositories

import com.mind.todolistwithdagger2.main.database.entity.Task

interface TaskRepository {

    fun getTask() : List<Task>
}