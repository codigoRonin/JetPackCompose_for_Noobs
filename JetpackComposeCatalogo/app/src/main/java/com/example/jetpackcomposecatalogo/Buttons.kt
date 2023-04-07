package com.example.jetpackcomposecatalogo

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyButtonExample() {
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

@Preview(name = "Ejemplo del componente Boton", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewButton() {
    MyButtonExample()
}
