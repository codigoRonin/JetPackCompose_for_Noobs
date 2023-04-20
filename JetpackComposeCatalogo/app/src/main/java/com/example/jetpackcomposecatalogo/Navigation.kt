package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

// En Jetpackcompose es singleActivity , tendremos un mainActivity que gestione todas las screens,
// ya no tendremos mas acivities ni fragments.

// Para  el tema de navegacion debemos añadir la siguiente dependencia 
// implementation "androidx.navigation:navigation-compose:2.5.3"

@Composable
fun Screen1(){
    
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue)){
        Text(text = "Pantalla 1", modifier = Modifier.align(Alignment.Center) )
    }
}
@Composable
fun Screen2(){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Yellow)){
        Text(text = "Pantalla 2", modifier = Modifier.align(Alignment.Center) )
    }
}

@Composable
fun Screen3(){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Magenta)){
        Text(text = "Pantalla 3", modifier = Modifier.align(Alignment.Center) )
    }
}
