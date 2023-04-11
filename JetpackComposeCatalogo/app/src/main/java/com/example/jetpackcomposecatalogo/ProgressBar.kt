package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyProgressBarExample1() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Red, strokeWidth = 8.dp)
        LinearProgressIndicator(
            Modifier.padding(top = 24.dp),
            color = Color.Red,
            backgroundColor = Color.Green
        )
    }
}

@Composable
fun MyProgressBarExample2() {
    var showLoadind by rememberSaveable() {
        mutableStateOf(false)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoadind) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 8.dp)
            LinearProgressIndicator(
                Modifier.padding(top = 24.dp),
                color = Color.Red,
                backgroundColor = Color.Green
            )
        }
        Button(onClick = { showLoadind = !showLoadind }) {
            Text(text = "Download File")
        }

    }
}

@Composable
fun MyProgressBarAdvanceExample() {

    var progressStatus by rememberSaveable {
        mutableStateOf(0f)
    }
    var stateIncrease by rememberSaveable {
        mutableStateOf(true)
    }

    var stateDecrease by rememberSaveable {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(progress = progressStatus)
        Row(Modifier.padding(24.dp)) {
            Button(
                enabled = stateIncrease,
                onClick = {
                    if (progressStatus < 1f) progressStatus += 0.1f else stateIncrease = false
                },
                modifier = Modifier.padding(24.dp, 0.dp),

            ) {
                Text(text = "Increase")
            }
            Button(
                enabled = stateDecrease,
                onClick = {
                    if (progressStatus > 0f) progressStatus -= 0.1f else stateDecrease = false
                },
                modifier = Modifier.padding(24.dp, 0.dp)
            ) {
                Text(text = "Decrease")
            }
        }
    }
}

@Preview(name = "Ejemplo de ProgressBar", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewProgressBar1() {
    MyProgressBarExample1()
}

@Preview(name = "Ejemplo de ProgressBar", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewProgressBar2() {
    MyProgressBarExample2()
}

@Preview(name = "Ejemplo de ProgressBar Avanzado", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewProgressBar3() {
    MyProgressBarAdvanceExample()
}