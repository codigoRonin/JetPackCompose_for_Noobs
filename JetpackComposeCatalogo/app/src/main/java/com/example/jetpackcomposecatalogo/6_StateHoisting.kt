package com.example.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class StateHoisting : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var MyText by rememberSaveable() { mutableStateOf("Hola") }

                    MyTextFieldStateHoisting(MyText) { MyText = it }
                }
            }
        }
    }
}

// State Hoisting es un patron para quitar estados de los composable,
// consiguiendo sacar el estado en un elemento superior

@Composable
fun MyTextFieldStateHoisting(text: String, onValueChanged: (String) -> Unit) {
    TextField(value = text, onValueChange = { onValueChanged(it) })
}

