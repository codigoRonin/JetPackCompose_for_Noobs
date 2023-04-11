package com.example.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HolaMundo("Michel")
                }
            }
        }
    }
}


//JetpackCompose
//Nuevo kit para desarrollar vistas nativas desde Android
//Problema xml -> entenderlo y transformalo -> tiempos de compilacion más largos
//
//Todas las cosas se programan en kotlin -> vista y logica ->  quita mucho código
//
//Pasamos de paradigma Imperativo cambia a declarativo
