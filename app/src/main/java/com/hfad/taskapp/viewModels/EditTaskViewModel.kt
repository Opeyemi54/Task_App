package com.hfad.taskapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.taskapp.model.TaskDao
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class EditTaskViewModel @AssistedInject constructor(
    @Assisted private val taskId: Long,
    private val dao: TaskDao
) : ViewModel() {

    val task = dao.get(taskId)

    private val _navigateToList = MutableLiveData<Boolean>(false)
    val navigateToList: LiveData<Boolean>
        get() = _navigateToList

    fun updateTask() {
        viewModelScope.launch {
            dao.update(task.value!!)
            _navigateToList.value = true
        }
    }

    fun deleteTask() {
        viewModelScope.launch {
            dao.delete(task.value!!)
            _navigateToList.value = true
        }
    }

    fun onNavigatedToList() {
        _navigateToList.value = false
    }

    @AssistedFactory
    interface Factory {
        fun create(taskId: Long): EditTaskViewModel
    }
}
