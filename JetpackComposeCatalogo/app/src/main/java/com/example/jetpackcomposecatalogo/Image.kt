package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyImageExample() {
    Image(
        painter = painterResource(id = R.drawable.dev_d2py_uhxjqo_unsplash),
        contentDescription = "Descripción de la imagen -> importante para invidentes y para testing",
        alpha = 0.5f
    )

}

@Composable
fun MyImageAdvanceExample() {
    Image(
        painter = painterResource(id = R.drawable.dev_d2py_uhxjqo_unsplash),
        contentDescription = "Comics",
        //  Modifier.clip(RoundedCornerShape(250f))
        Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape)
    )

}

@Composable
fun MyIconExample() {
    // Icon es parte de Material Design por lo que por defecto los va a pintar de 24dp x 24dp
    // ademas contiene un objeto de tipo localContentColor  para tintar las imagenes de una forma
    // más sencilla.
    Icon(
        imageVector = Icons.Rounded.Star,  // Para ver iconos que existen https://fonts.google.com/icons
        contentDescription = "Icono de estrella",
        tint = Color.Red
    )

    // Vemos que en la web aparecen muchos más iconos, si queremos disponer de ellos tendremos que
    // anadir una libreria -> (aunque pesa bastante)
    // implementation "androidx.compose.material:material-icons-extended:$compose_ui_version"

}

@Preview(name = "Ejemplo del componente Image", showSystemUi = true, showBackground = true)
@Composable
fun MyPreviewImage1() {
    MyImageExample()
}

@Preview(
    name = "Ejemplo del componente Image Circulares", showSystemUi = true, showBackground = true
)
@Composable
fun MyPreviewImage2() {
    MyImageAdvanceExample()
}

@Preview(
    name = "Ejemplo del componente Icon", showSystemUi = true, showBackground = true
)
@Composable
fun MyPreviewIcon1() {
    MyIconExample()
}
