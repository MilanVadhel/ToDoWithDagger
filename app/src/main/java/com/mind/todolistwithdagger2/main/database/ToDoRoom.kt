package com.mind.todolistwithdagger2.main.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mind.todolistwithdagger2.main.database.dao.TaskDao
import com.mind.todolistwithdagger2.main.database.entity.Task

@Database(entities = [Task::class], version = 1)
abstract class ToDoRoom : RoomDatabase() {
    abstract fun getTaskDao() : TaskDao
}