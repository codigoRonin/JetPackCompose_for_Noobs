package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Coronavirus
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

// Todos los componentes del Scaffold se pueden usar tambien como componentes sueltos !!!

@Composable
fun MyScaffoldExample() {

    // Los Scafffold necesitan guardar el estado para poder user algunos de los componentes
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = {
        MyTopAddBar {
            coroutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Has pulsado $it")
            }
        }
    }, scaffoldState = scaffoldState) { contentPadding ->
        // Screen content
        Box(modifier = Modifier.padding(contentPadding)) { /* ... */ }
    }

}

@Composable
fun MyTopAddBar(onClickIcon: (String) -> Unit) {
    TopAppBar(title = { Text(text = "Mi primera Toolbar") },
        backgroundColor = Color.Magenta,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onClickIcon("Atrás") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = { onClickIcon("Virus") }) {
                Icon(imageVector = Icons.Filled.Coronavirus, contentDescription = "CoronaVirus")
            }
        }
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyScaffoldPreview() {
    MyScaffoldExample()
}