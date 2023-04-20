package com.example.jetpackcomposecatalogo.model

sealed class Routes (val routes: String){
    object Pantalla1 : Routes("Pantalla 1")
    object Pantalla2 : Routes("Pantalla 2")
    object Pantalla3 : Routes("Pantalla 3")
    // con parametro obligatorio
    object Pantalla6 : Routes("Pantalla 6/{name}"){
        fun createRoute(name:String) = "Pantalla 6/$name"
    }
    // con parametro opcional
    object Pantalla7 : Routes("Pantalla 7?name={name}"){
        fun createRoute(name:String) = "Pantalla 7?name=$name"
    }

}