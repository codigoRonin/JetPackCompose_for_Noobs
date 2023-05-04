package com.codigoronin.todoapp.addtasks.domain

import com.codigoronin.todoapp.addtasks.data.TaskRepository
import com.codigoronin.todoapp.addtasks.ui.model.TaskModel
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {

    suspend operator fun invoke(taskModel: TaskModel) {
        taskRepository.update(taskModel)
    }
}