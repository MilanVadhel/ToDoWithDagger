package com.mind.todolistwithdagger2.main.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mind.todolistwithdagger2.R
import com.mind.todolistwithdagger2.main.database.entity.Task
import kotlinx.android.synthetic.main.task_row.view.*
import java.text.SimpleDateFormat
import java.util.*

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private lateinit var taskList: ArrayList<Task>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_row, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bindTask(taskList[position])
        holder.cardTask.setOnClickListener {
            //If expanded = true then collapse it
            if(taskList[position].isExpanded){
                holder.collapseTask()
                taskList[position].isExpanded = false
            }else{
                holder.expandTask()
                taskList[position].isExpanded = true
            }
        }
    }

    override fun getItemCount(): Int {
        if (::taskList.isInitialized) {
            return taskList.size
        } else {
            return 0
        }
    }

    fun setList(list: List<Task>) {
        this.taskList = list as ArrayList<Task>
    }

    fun removeItem(position: Int) {
        taskList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun getData(): ArrayList<Task> {
        return taskList
    }

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardTask : CardView = itemView.findViewById(R.id.taskCard)
        val desc : TextView = itemView.findViewById(R.id.txtDescription)

        @SuppressLint("SimpleDateFormat")
        fun bindTask(task: Task) {
            if(!task.isExpanded){
                itemView.txtTitle.text = task.title
                itemView.txtDescription.text = task.description
                itemView.txtCategory.text = task.category
                itemView.txtTime.text = SimpleDateFormat("dd MMM yyyy, hh:mm a").format(Date(task.time.toLong()))
            }else{
                expandTask()
            }
        }

        fun expandTask() {
            itemView.txtDescription.maxLines = 5
            itemView.txtDescription.maxEms = 100
        }

        fun collapseTask() {
            itemView.txtDescription.maxLines = 1
            itemView.txtDescription.maxEms = 8
        }

    }
}