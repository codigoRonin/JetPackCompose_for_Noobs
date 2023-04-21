package com.example.jetpackcomposecatalogo

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyAlertDialog() {

    AlertDialog(onDismissRequest = {},
        title = { Text(text = "Mi Título") },
        text = { Text(text = " Esta es la descripcion") },
        confirmButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Accept")
            }
        },
        dismissButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Cancel")
            }
        })
}

@Composable
fun MyAlertDialogComplete(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    if (show) {
        AlertDialog(onDismissRequest = { onDismiss() }, // Accion cuando el usuario pulse fuera
            title = { Text(text = "Mi Título") },
            text = { Text(text = " Esta es la descripcion") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Accept")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Cancel")
                }
            })
    }
}

@Composable
fun MySimpleDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = { /*TODO*/ }) {
            //Aqui pondriamos la vista
            Text(text = "Mensaje del diálogo")
        }
    }
}

@Composable
fun MySimpleDialogCustom(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            //Aqui pondriamos la vista
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {

                Text(text = "Mensaje del diálogo")
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyPreviewSimpleDialogCustom() {
    var show by rememberSaveable { mutableStateOf(false) }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Mostar Diálogo")
        }
        MySimpleDialogCustom(show = show, onDismiss = { show = false })
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyPreviewSimpleDialog() {
    var show by rememberSaveable { mutableStateOf(false) }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Mostar Diálogo")
        }
        MySimpleDialog(show = show, onDismiss = { show = false })
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyPreviewDialogComplete() {
    var show by rememberSaveable { mutableStateOf(false) }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Mostar Diálogo")
        }
        MyAlertDialogComplete(show = show,
            onDismiss = { show = false },
            onConfirm = { Log.i("Michel", "Se ha pulsado acceptar") })
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyPreviewDialog() {
    MyAlertDialog()
}

