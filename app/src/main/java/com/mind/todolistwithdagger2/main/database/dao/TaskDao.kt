package com.mind.todolistwithdagger2.main.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.mind.todolistwithdagger2.main.database.entity.Task

@Dao
interface TaskDao {

    @Query("select * from task")
    fun getTasks() : List<Task>
}