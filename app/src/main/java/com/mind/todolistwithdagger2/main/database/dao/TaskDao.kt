package com.mind.todolistwithdagger2.main.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mind.todolistwithdagger2.main.database.entity.Task

@Dao
interface TaskDao {

    @Insert
    fun addTask(task: Task)

    @Query("select * from task where flag = 0 ORDER BY time DESC")
    fun getTasks() : List<Task>


    @Query("UPDATE task SET flag = 1  WHERE id = :archivedTaskId")
    fun addToArchive(archivedTaskId: Int)

    @Query("select * from task where flag = 1 ORDER BY time DESC")
    fun getArchivedTasks() : List<Task>

    @Query("UPDATE task SET flag = 0  WHERE id = :archivedTaskId")
    fun moveToToDo(archivedTaskId: Int)
}