package com.example.ejercicio1_filascolumnascajas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejercicio1_filascolumnascajas.ui.theme.Ejercicio1_FilasColumnasCajasTheme

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .weight(1f), Alignment.Center) {
            Text(text = "Ejemplo1")
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .background(Color.Red)
                    .weight(1f), Alignment.Center) {
                Text(text = "Ejemplo2")
            }
            Box(
                Modifier
                    .fillMaxHeight()
                    .background(Color.Green)
                    .weight(1f), Alignment.Center) {
                Text(text = "Ejemplo3")
            }
        }

        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Magenta)
                .weight(1f), Alignment.BottomCenter) {
            Text(text = "Ejemplo2")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Ejercicio1_FilasColumnasCajasTheme {
        MyComplexLayout()
    }
}