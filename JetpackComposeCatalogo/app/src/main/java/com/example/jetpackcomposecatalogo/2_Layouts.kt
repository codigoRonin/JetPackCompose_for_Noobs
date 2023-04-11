package com.example.jetpackcomposecatalogo


import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

@Composable
fun MyColumn(){
    /*  Column(Modifier.fillMaxSize()){
          Text(text = "Hola Ejemplo 1",
              Modifier
                  .background(Color.Red)
                  .weight(1f))
          Text(text = "Hola Ejemplo 2",
              Modifier
                  .background(Color.Black)
                  .weight(3f))
          Text(text = "Hola Ejemplo 3",
              Modifier
                  .background(Color.Blue)
                  .weight(1f))
      }*/

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween){
        Text(text = "Hola Ejemplo 1",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Hola Ejemplo 2",
            Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Hola Ejemplo 3",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Hola Ejemplo 3",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Hola Ejemplo 3",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Hola Ejemplo 3",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Hola Ejemplo 3",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Hola Ejemplo 3",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Hola Ejemplo 1",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Hola Ejemplo 2",
            Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Hola Ejemplo 3",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Hola Ejemplo 3",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Hola Ejemplo 3",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Hola Ejemplo 3",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Hola Ejemplo 3",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Hola Ejemplo 3",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp))

    }
}

@Composable
fun MyRow(){
    /*  Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween){
          Text(text = "Hola Ejemplo 1")
          Text(text = "Hola Ejemplo 2")
          Text(text = "Hola Ejemplo 3")

      }*/

    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())){
        Text(text = "Hola Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Hola Ejemplo 2", Modifier.width(100.dp))
        Text(text = "Hola Ejemplo 3", Modifier.width(100.dp))
        Text(text = "Hola Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Hola Ejemplo 2", Modifier.width(100.dp))
        Text(text = "Hola Ejemplo 3", Modifier.width(100.dp))

    }

}

@Composable
fun MyBox() {
    Box(modifier= Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Box (modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .background(Color.Red)
            .verticalScroll(
                rememberScrollState()
            )){
            Text ("Esto es un ejemplo de texto en mi box")
        }
    }
}


@Composable
fun MySpacer(size:Int){
    Spacer(Modifier.height(size.dp))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview1() {
    JetpackComposeCatalogoTheme {
        MyBox()
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    JetpackComposeCatalogoTheme {
        MyColumn()
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview3() {
    JetpackComposeCatalogoTheme {
        MyRow()
    }
}