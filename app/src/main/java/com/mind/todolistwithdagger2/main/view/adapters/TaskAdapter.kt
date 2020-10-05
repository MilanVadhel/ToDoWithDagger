package com.mind.todolistwithdagger2.main.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mind.todolistwithdagger2.R
import com.mind.todolistwithdagger2.main.database.entity.Task

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private lateinit var taskList: List<Task>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_row,parent,false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bindTask(taskList[position])
    }

    override fun getItemCount(): Int {
        if(::taskList.isInitialized){
            return taskList.size
        }else{
            return 0
        }
    }

    fun setList(list: List<Task>){
        this.taskList = list
    }
    class TaskViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        fun bindTask(task: Task){

        }
    }
}