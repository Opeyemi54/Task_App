package com.hfad.taskapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class EditTaskViewModelFactory(
    private val factory: EditTaskViewModel.Factory,
    private val taskId: Long
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return factory.create(taskId) as T
    }
}
