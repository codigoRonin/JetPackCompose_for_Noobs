package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposecatalogo.model.SuperHero

@Composable
fun MyRecyclerViewExample1() {
    //LazyRow(content = )
    LazyColumn {
        // Los RecyclerView solo reciben items
        item() { Text(text = "Ejemplo 1") }
        items(7) {
            Text(text = "Este es el ejemplo $it")
        }
    }
}

@Composable
fun MyRecyclerViewExample2() {
    var myList = listOf("Michel", "Juana", "Silvia", "Lucia")

    LazyColumn {
        // Lo normal es que los datos lleguen en un listado,además podriamos tener
        // un header y un footer ya que se crea en orden
        item { Text(text = "HEADER") }
        items(myList) {
            Text(text = "Hola me llamo $it")
        }
        item { Text(text = "FOOTER") }

    }

}

@Composable
fun SuperHeroView() {


}

fun getSuperHeroes(): List<SuperHero> {

    return listOf(
        SuperHero("Siperman", "Peter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverin", "James Howlet", "Marvel",R.drawable.logan),
        SuperHero("Batman", "Bruce Wayne", "DC",R.drawable.batman),
        SuperHero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        SuperHero("Green Lantern","Alan Scott", "DC",R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyRecyclerPreview() {
    //MyRecyclerViewExample1()
    MyRecyclerViewExample2()
}