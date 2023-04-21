package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.jetpackcomposecatalogo.model.Routes.*

// En Jetpackcompose es singleActivity , tendremos un mainActivity que gestione todas las screens,
// ya no tendremos mas acivities ni fragments.

// Para  el tema de navegacion debemos añadir la siguiente dependencia 
// implementation "androidx.navigation:navigation-compose:2.5.3"

@Composable
fun Screen1(navController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(
            text = "Pantalla 1",
            modifier = Modifier
                .align(Alignment.Center)
                //     .clickable { navController.navigate("Pantalla 2") }) // Basic
                .clickable { navController.navigate(Pantalla2.routes) },   // Like a pro
        )
    }
}

@Composable
fun Screen2(navController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(
            text = "Pantalla 2",
            modifier = Modifier
                .align(Alignment.Center)
                //        .clickable { navController.navigate("Pantalla 3") }) // Basic
                .clickable { navController.navigate(Pantalla3.routes) },
        )
    }
}

@Composable
fun Screen3(navController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            text = "Pantalla 3",
            modifier = Modifier
                .align(Alignment.Center)
                //    .clickable { navController.navigate("Pantalla 1") }) // Basic
                //    .clickable { navController.navigate(Pantalla1.routes) },   // Like a pro
                .clickable { navController.navigate("Pantalla4/Michel") }  // With argument
        )
    }
}

@Composable
fun Screen4(navController: NavHostController, name: String) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(
            text = name,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate("Pantalla5/1975") },   // With argument (no String)
        )
    }
}

@Composable
fun Screen5(navController: NavHostController, age: Int) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Text(
            text = age.toString(),
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Pantalla6.createRoute("Juanito")) },   // With argument like a pro
        )
    }
}

@Composable
fun Screen6(navController: NavHostController, name: String) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Text(
            text = name,
            modifier = Modifier
                .align(Alignment.Center)
                //  .clickable { navController.navigate(Pantalla7.routes) },   // With optional argument like a pro
                .clickable { navController.navigate(Pantalla7.createRoute("DAM")) },   // With optional argument like a pro
        )
    }
}

@Composable
fun Screen7(navController: NavHostController, name: String?) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(
            text = "Me llamo $name",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Pantalla1.routes) },   // With argument like a pro
        )
    }
}





