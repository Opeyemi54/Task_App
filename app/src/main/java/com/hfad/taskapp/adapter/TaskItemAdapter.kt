package com.hfad.taskapp.adapter



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hfad.taskapp.databinding.TaskItemBinding
import com.hfad.taskapp.model.Task

class TaskItemAdapter(private val clickListener: (taskId: Long) -> Unit)
        : ListAdapter<Task, TaskItemAdapter.TaskItemViewHolder>(TaskDiffItemCallback()) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                          : TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {

        val item = getItem(position)
        holder.bind(item, clickListener)
    }





    class TaskItemViewHolder(private val binding: TaskItemBinding)
                             : RecyclerView.ViewHolder(binding.root) {



           companion object {
               fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                   val layoutInflater = LayoutInflater.from(parent.context)
                   val binding = TaskItemBinding.inflate(layoutInflater, parent, false)

                   return TaskItemViewHolder(binding)
               }
           }
           fun bind(item: Task, clickListener: (taskId: Long) -> Unit) {

               binding.task = item
               binding.root.setOnClickListener {
                   clickListener(item.taskId)
               }

           }


        }

    }