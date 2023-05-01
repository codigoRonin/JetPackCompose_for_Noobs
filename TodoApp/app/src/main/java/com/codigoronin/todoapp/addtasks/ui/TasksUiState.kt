package com.codigoronin.todoapp.addtasks.ui

import com.codigoronin.todoapp.addtasks.ui.model.TaskModel

sealed interface TasksUiState {

    object Loading : TasksUiState
    data class Error (val throwable: Throwable):TasksUiState
    data class Success (val tasks:List<TaskModel>):TasksUiState

}