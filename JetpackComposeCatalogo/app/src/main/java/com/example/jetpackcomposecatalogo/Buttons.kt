package com.example.jetpackcomposecatalogo

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyButtonExample1() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { Log.i("Michel", "Esto es un botón") },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Yellow
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Hola")

        }
    }
}

@Composable
fun MyButtonExample2() {
    var enabled by rememberSaveable() { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Yellow
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Hola")

        }
    }
}

@Composable
fun MyOutlinedButton() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(
            enabled = true,
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors( // outLinedButtonColors no permite disableBackgroundColor
                backgroundColor = Color.Red,
                disabledBackgroundColor = Color.Blue,
                contentColor = Color.Yellow,
                disabledContentColor = Color.Red
            )
        ) {
            Text(text = "Esto es un OutlinedButton")
        }
    }
}
@Composable
fun MyTextButton(){

    // Realmente es el mismo boton porque dentro podriamos colocar cualquier cosa no solo un Text
    // pero eso si, no tendría borde. Además tambien podriamos hacer que un Text fuese clicable y
    // obtendriamos lo mismo.

    TextButton(onClick = { /*TODO*/ }) {
        Text("Mi boton")
    }
}
@Preview(name = "Ejemplo del componente OutLinedButton", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewButton4() {
    MyTextButton()
}
@Preview(name = "Ejemplo del componente OutLinedButton", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewButton3() {
    MyOutlinedButton()
}

@Preview(name = "Ejemplo del componente Button", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewButton1() {
    MyButtonExample1()
}

@Preview(
    name = "Ejemplo del componente Button evento onClick",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MyPreviewButton2() {
    MyButtonExample2()
}