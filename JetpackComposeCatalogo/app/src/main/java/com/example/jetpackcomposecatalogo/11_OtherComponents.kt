package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color.Red,
        contentColor = Color.Green,
        border = BorderStroke(10.dp, Color.Yellow)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 1")
        }

    }
}

/*Existe otro componente igual Card llamado Surface que la única diferencia es que Surface viene con
una elevation por defecto,un shape  MaterialTheme.shapes.Medium (Creo que es mejor usar Card)*/
@Composable
fun MyBadgeBox() {
    Column() {
        BadgedBox(modifier = Modifier.padding(16.dp),
            badge = {
                Badge(backgroundColor = Color.Green) {
                    Text("3000")
                }

            },
            content = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "estrella")
            })
    }

}

@Composable
fun MyDivider() {
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), color = Color.Red
    )
}

@Composable
fun MyDropDownMenu() {
    var selectedItem by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val languages = listOf("C", "C++", "Java", "Kotlin", "Swift", "Python")

    Column(modifier = Modifier.padding(24.dp)) {

        OutlinedTextField(
            value = selectedItem,
            onValueChange = { selectedItem = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth().padding(24.dp)
        ) {
            languages.forEach { language ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedItem = language
                }) {
                    Text(text = language)
                }
            }
        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyPreviewOthersComponents() {
    //MyCard()
    //MyBadgeBox()
    //MyDivider()
    MyDropDownMenu()
}