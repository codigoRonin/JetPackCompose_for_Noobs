package com.codigoronin.todoapp.addtasks.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codigoronin.todoapp.addtasks.ui.model.TaskModel
import javax.inject.Inject

class TasksViewModel @Inject constructor() : ViewModel() {


    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    // Como los LiveData no funcionan del bien con los listados y mas los que se tiene que actulizar
    // Se podria usar Flows o un mutablestatelist

    private val _tasks = mutableStateListOf<TaskModel>()
    val tasks: List<TaskModel> = _tasks

    fun onDialogClose() {
        _showDialog.value = false
    }

    fun onTaskAdd(task: String) {
        _tasks.add(TaskModel(task = task))
        _showDialog.value = false
    }

    fun onShowDialogClick() {
        _showDialog.value = true
    }

    fun onCheckBoxSelected(taskModel: TaskModel) {
        val index = _tasks.indexOf(taskModel)
        //  _tasks[index].selected = !_tasks[index].selected // Deberia ser asi pero no sabe que ha cambiado por lo que no lo redibuja

        _tasks[index] =
            _tasks[index].let {// Para solucionarlo lo copiamos entero con el valor selected cambiado
                it.copy(selected = !it.selected)
            }
    }

    fun onItemRemove(taskModel: TaskModel) {
        val task = _tasks.find { it.id == taskModel.id }
        _tasks.remove(task)
    }

}