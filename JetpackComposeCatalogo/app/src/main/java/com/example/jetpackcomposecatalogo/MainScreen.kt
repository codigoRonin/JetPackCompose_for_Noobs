package com.example.jetpackcomposecatalogo

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

@Composable
fun HolaMundo(name: String) {

    Text("Hola Mundo, bienvenido $name")
}


@Preview(name = "Vista Simple", showBackground = true)
@Composable
fun DefaultPreview() {
    HolaMundo(name = "Michel")
}

@Preview(
    name = "Nombre de la preview",
    showBackground = true,
    showSystemUi = true,
    heightDp = 200,
    widthDp = 100,
    //   locale =
    apiLevel = 33,
    device = Devices.NEXUS_6
)
@Composable
fun MyPreview() {
    JetpackComposeCatalogoTheme {
        HolaMundo(name = "Paco")
    }
}
/*
La única limitación de las previous el componente de dentro no puede recibir parametros
Solución -> crear un método fake por encima

@Preview(name = "Vista Simple", showBackground = true)
@Composable
fun Hola(name = "Michel") {
    Text("Hola, bienvenido $name")
    }
}*/