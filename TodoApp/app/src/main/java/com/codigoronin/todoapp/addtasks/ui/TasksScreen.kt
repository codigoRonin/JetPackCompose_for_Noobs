package com.codigoronin.todoapp.addtasks.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable

fun TasksScreen(tasksViewModel: TasksViewModel) {

    Box(modifier = Modifier.fillMaxSize()) {
        AddTaskDialog(show = true, onDismiss = {}, onTaskAdded = {})
        FabDialog(Modifier.align(Alignment.BottomEnd))
    }

}

@Composable
fun FabDialog(modifier: Modifier) {

    FloatingActionButton(
        onClick = { },
        modifier = modifier
            .padding(16.dp), backgroundColor = Color.Cyan
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Task")
    }
}

@Composable
fun AddTaskDialog(show: Boolean, onDismiss: () -> Unit, onTaskAdded:(String) -> Unit) {
    var myTask by rememberSaveable { mutableStateOf("") }
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {

            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {

                Text(
                    text = "ADD TASK",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.size(16.dp))
                TextField(
                    value = myTask,
                    onValueChange = { myTask = it },
                    singleLine = true,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.size(16.dp))
                Button(onClick = { onTaskAdded(myTask) }, Modifier.fillMaxWidth()) {
                    Text(text = "Add Task")
                }
            }

        }
    }

}