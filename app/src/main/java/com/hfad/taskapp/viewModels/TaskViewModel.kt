package com.hfad.taskapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.taskapp.model.Task
import com.hfad.taskapp.model.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val dao: TaskDao
) : ViewModel() {
    var newTaskName =""

    val tasks = dao.getAll()

    private val _navigateToTask = MutableLiveData<Long?>()
    val navigateToTask: LiveData<Long?>
        get() = _navigateToTask

    fun addTask() {
        viewModelScope.launch {
            val task = Task()
            task.taskName = newTaskName
            dao.insert(task)
        }
    }

    fun onsaveButtonClick() {
        addTask()
    }

    fun onTaskClicked(taskId: Long) {
        _navigateToTask.value = taskId
    }

    fun onTaskNavigated() {
        _navigateToTask.value = null
    }


}
