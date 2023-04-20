package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
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

    Scaffold(
        topBar = {
            /*MyTopAddBar {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Has pulsado $it")
                }*/

            MyTopAddBarForDrawer(
                onClickIcon = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Has pulsado $it")
                    }
                }, onClickDrawer = { coroutineScope.launch { scaffoldState.drawerState.open() } })
        },
        scaffoldState = scaffoldState,
        bottomBar = { MyBottonNavigation() },
        floatingActionButton = { MyFAB() },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = false,
        drawerContent = {
            MyDrawer(
                listOf(
                    "Opcion 1",
                    "Opcion2",
                    "Opcion3",
                    "Opcion 4",
                    "Opcion 5"
                ), onCloseDrawer = { coroutineScope.launch { scaffoldState.drawerState.close() } }
            )
        }

    )

    { contentPadding ->
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
            IconButton(onClick = { onClickIcon("Home") }) {
                Icon(imageVector = Icons.Filled.Home, contentDescription = "Back")
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

@Composable
fun MyBottonNavigation() {
    var index by remember { mutableStateOf(0) }

    BottomNavigation(backgroundColor = Color.Magenta, contentColor = Color.White) {
        BottomNavigationItem(
            selected = index == 0, onClick = { index = 0 }, icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            },
            label = { Text(text = "Home") }
        )
        BottomNavigationItem(
            selected = index == 1, onClick = { index = 1 }, icon = {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
            },
            label = { Text(text = "Favorite") }
        )
        BottomNavigationItem(
            selected = index == 2, onClick = { index = 2 }, icon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Person")
            },
            label = { Text(text = "Person") }
        )
    }
}

@Composable
fun MyFAB() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        backgroundColor = Color.Cyan,
        contentColor = Color.Black
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")

    }
}

@Composable
fun MyDrawer(nombres: List<String>, onCloseDrawer: () -> Unit) {

    Column(Modifier.padding(8.dp)) {

        nombres.forEach {
            Text(
                text = it,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onCloseDrawer() }
            )
        }
    }
}

@Composable
fun MyTopAddBarForDrawer(onClickIcon: (String) -> Unit, onClickDrawer: () -> Unit) {
    TopAppBar(title = { Text(text = "Mi primera Toolbar") },
        backgroundColor = Color.Magenta,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onClickDrawer() }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
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