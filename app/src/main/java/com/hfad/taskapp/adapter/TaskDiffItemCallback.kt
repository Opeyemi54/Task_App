package com.hfad.taskapp.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hfad.taskapp.model.Task

class TaskDiffItemCallback : DiffUtil.ItemCallback<Task>() {
    override fun areContentsTheSame(oldItem: Task, newItem: Task)
      = (oldItem.taskId == newItem.taskId)

    override fun areItemsTheSame(oldItem: Task, newItem: Task) = (oldItem == newItem)


}