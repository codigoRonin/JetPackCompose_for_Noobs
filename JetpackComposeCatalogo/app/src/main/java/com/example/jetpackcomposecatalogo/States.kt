package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


// La vista se modifica mediante ordenes (normalmente). Los States son estados a los cuales nos
// enganchamos de algun modo y cuando se mofiquen automaticamente se actualizaran nuestas vistas.

// Recomposición:
// Cuando un texto se modifica el componente no se actualiza se recompone,se vuele a crear de nuevo.
// La ventaja que siempre vamos a tener la ultima version y evitaremos fallos de la UI-

@Composable
fun MyStateExample1() {

    var counter = 0

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter+=1 }) {
            Text(text = "Pulsar")
        }

        Text("Se ha pulsado el botón $counter veces")
    }
}

@Composable
fun MyStateExample2() {

    var counter = remember {mutableStateOf(0)}

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter.value +=1 }) {
            Text(text = "Pulsar")
        }

        Text("Se ha pulsado el botón ${counter.value} veces")
    }
}

@Composable
fun MyStateExample3() {

    // Debido al ciclo de vida de las activities, si por ejemplo giramos la pantalla
    // al destruirse la activity nuestro contador se va a poner a 0.
    // Para mantener el estado aunque la vista se destruya lo haremos con  rememberSavable()

    var counter = rememberSaveable() {mutableStateOf(0)}

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter.value +=1 }) {
            Text(text = "Pulsar")
        }

        Text("Se ha pulsado el botón ${counter.value} veces")
    }
}

@Composable
fun MyStateExample4() {

    // Para no tener que usar continuamente el .value podemos usar by en cuanta del igual
    // A fecha de hoy todavía hay problema con estos imports y los tenemos que colocar a mano
    // import androidx.compose.runtime.getValue
    // import androidx.compose.runtime.setValue

    var counter by rememberSaveable() {mutableStateOf(0)}

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter +=1 }) {
            Text(text = "Pulsar")
        }

        Text("Se ha pulsado el botón $counter veces")
    }
}

@Preview(name = "Ejemplo State", showSystemUi = true, showBackground = true)
@Composable
fun MyPreview1() {
    MyStateExample1()
}

@Preview(name = "Ejemplo remember", showSystemUi = true, showBackground = true)
@Composable
fun MyPreview2() {
    MyStateExample2()
}

@Preview(name = "Ejemplo rememberSaveable Ciclo de Vida", showSystemUi = true, showBackground = true)
@Composable
fun MyPreview3() {
    MyStateExample3()
}

@Preview(name = "Ejemplo State Property", showSystemUi = true, showBackground = true)
@Composable
fun MyPreview4() {
    MyStateExample4()
}