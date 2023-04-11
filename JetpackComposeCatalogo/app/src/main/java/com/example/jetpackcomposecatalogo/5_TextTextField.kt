package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun MyText() {

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Ejemplo del Componente Text")
        Text("Ejemplo del Componente Text", color = Color.Red)
        Text("Ejemplo del Componente Text", fontWeight = FontWeight.Bold)
        Text("Ejemplo del Componente Text", fontWeight = FontWeight.Light)
        Text("Ejemplo del Componente Text", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            "Ejemplo del Componente Text",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            "Ejemplo del Componente Text",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            "Ejemplo del Componente Text", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )
        // Si no queremos crear un style y solo queremos acceder a uno de los estilos podemos obviar
        // TextStyle,directamente FontFamily, TextDecoration, etc..
        Text("Ejemplo del Componente Text", fontFamily = FontFamily.Monospace)
        Text("Ejemplo del Componente Text", fontSize = 16.sp)

    }

}

@Composable
fun MyTextField() {
    var myText by rememberSaveable() { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = myText, onValueChange = { myText = it })

    }

}

@Composable
fun MyTextFieldAdvance() {
    var myText by rememberSaveable() { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = myText,
            onValueChange = {
                myText =
                    if (it.contains("a"))
                        it.replace("a", "@")
                    else
                        it
            },
            label = { Text(text = "Introduce tu nombre") })

    }

}

@Composable
fun MyTextFieldOutlined() {
    var myText by rememberSaveable() { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = myText,
            onValueChange = { myText = it },
            label = {
                Text(text = "Introduce tu nombre")
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Red,
                unfocusedBorderColor = Color.Green
            )
        )

    }

}

@Preview(name = "Ejemplos con el componente Text", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewText() {
    MyText()
}

@Preview(name = "Ejemplo con el componente TextField", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewTextField() {
    MyTextField()
}

@Preview(name = "Ejemplo TextField Avanzado", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewTextFieldAdvance() {
    MyTextFieldAdvance()
}

@Preview(name = "Ejemplo OutlinedTextField", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewTextFieldOutlined() {
    MyTextFieldOutlined()
}