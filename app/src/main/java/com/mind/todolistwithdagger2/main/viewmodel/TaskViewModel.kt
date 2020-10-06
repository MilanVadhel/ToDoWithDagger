package com.mind.todolistwithdagger2.main.viewmodel

import androidx.lifecycle.MutableLiveData
import com.mind.todolistwithdagger2.main.database.entity.Task
import com.mind.todolistwithdagger2.main.repositories.TaskRepository
import com.unittestsample.app.presentation.common.base.BaseViewModel
import javax.inject.Inject

class TaskViewModel @Inject constructor(private val taskRepository: TaskRepository): BaseViewModel(){

    internal val taskLiveEvent : MutableLiveData<List<Task>> = MutableLiveData()
    internal val archivedTaskLiveEvent : MutableLiveData<List<Task>> = MutableLiveData()
    fun addTask(task: Task){
        taskRepository.addTask(task)
    }

    fun getTasks(){
        taskLiveEvent.value = taskRepository.getTask()
    }

    fun getArchivedTask(){
        archivedTaskLiveEvent.value = taskRepository.getArchivedTask()
    }

    fun addToArchive(archivedTaskId: Int) {
        taskRepository.addToArchive(archivedTaskId)
    }
}