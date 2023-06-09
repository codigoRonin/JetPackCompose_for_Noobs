package com.codigoronin.todoapp.addtasks.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codigoronin.todoapp.addtasks.domain.AddTaskUseCase
import com.codigoronin.todoapp.addtasks.domain.DeleteTaskUseCase
import com.codigoronin.todoapp.addtasks.domain.GetTasksUseCase
import com.codigoronin.todoapp.addtasks.domain.UpdateTaskUseCase
import com.codigoronin.todoapp.addtasks.ui.TasksUiState.*
import com.codigoronin.todoapp.addtasks.ui.model.TaskModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    getTasksUseCase: GetTasksUseCase
) : ViewModel() {

    val uiState: StateFlow<TasksUiState> = getTasksUseCase().map(::Success)
        .catch { Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    // Como los LiveData no funcionan bien con los listados y mas los que se tienen que actualizar
    // Se podria usar Flows o un mutablestatelist

    // private val _tasks = mutableStateListOf<TaskModel>()
    // val tasks: List<TaskModel> = _tasks

    fun onDialogClose() {
        _showDialog.value = false
    }

    fun onTaskAdd(task: String) {
        //   _tasks.add(TaskModel(task = task))
        //  _showDialog.value = false

        viewModelScope.launch {
            addTaskUseCase(TaskModel(task = task))
        }
    }

    fun onShowDialogClick() {
        _showDialog.value = true
    }

    fun onCheckBoxSelected(taskModel: TaskModel) {
        /* val index = _tasks.indexOf(taskModel)
         //  _tasks[index].selected = !_tasks[index].selected // Deberia ser asi pero no sabe que ha cambiado por lo que no lo redibuja

         _tasks[index] =
             _tasks[index].let {// Para solucionarlo lo copiamos entero con el valor selected cambiado
                 it.copy(selected = !it.selected)
             }*/
        viewModelScope.launch { updateTaskUseCase(taskModel.copy(selected = !taskModel.selected)) }
    }

    fun onItemRemove(taskModel: TaskModel) {
        /* val task = _tasks.find { it.id == taskModel.id }
         _tasks.remove(task)*/
        viewModelScope.launch {
            deleteTaskUseCase(taskModel = taskModel)
        }
    }

}