package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MySwitchExample() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Green,
            checkedThumbColor = Color.Magenta,
            checkedTrackColor = Color.Blue,
            checkedTrackAlpha = 0.5f,
            uncheckedTrackAlpha = 0.5f,
            disabledCheckedTrackColor = Color.Yellow,
            disabledCheckedThumbColor = Color.Yellow,
            disabledUncheckedThumbColor = Color.Gray,
            disabledUncheckedTrackColor = Color.Gray
        )
    )
}

@Composable
fun MyCheckBoxExample() {
    var state by rememberSaveable { mutableStateOf(false) }

    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Green
        )
    )
}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo 1")
    }
}


@Preview(name = "Ejemplo de Checkbox con texto", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewCheckBox2() {
    //Lo meto dentro de una columna para poder alinear la fila centrada verticalmente
    Column() {
        MyCheckBoxWithText()
        MyCheckBoxWithText()
        MyCheckBoxWithText()
    }
}

@Preview(name = "Ejemplo de Checkbox", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewCheckBox1() {
    MyCheckBoxExample()
}

@Preview(name = "Ejemplo de Switch", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewSwitch() {
    MySwitchExample()
}