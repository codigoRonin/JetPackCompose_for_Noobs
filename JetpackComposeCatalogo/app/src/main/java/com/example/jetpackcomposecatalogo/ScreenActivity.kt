package com.example.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposecatalogo.model.Routes
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class ScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    /* Navegacion Básica
                    val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = "Pantalla 1" ){
                        composable("Pantalla 1" ){ Screen1(navigationController)}
                        composable("Pantalla 2" ){ Screen2(navigationController)}
                        composable("Pantalla 3" ){ Screen3(navigationController)}
                        */
                    /* Navegacion like a pro -> Routes para evitar crashear los nombres de las screens */
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Pantalla1.routes
                    ) {
                        composable(Routes.Pantalla1.routes) { Screen1(navigationController) }
                        composable(Routes.Pantalla2.routes) { Screen2(navigationController) }
                        composable(Routes.Pantalla3.routes) { Screen3(navigationController) }
                        // Pasar argumentos obligatorios de manera básica
                        composable("Pantalla4/{name}") { backStackEntry -> //backStackEntry es el nombre que se suele dar pero lo llamo como me da la gana
                            Screen4(
                                navigationController,
                                backStackEntry.arguments?.getString("name").orEmpty()
                            )
                        }
                        // Pasar argumentos obligatorios que no sean String de manera básica
                        composable("Pantalla5/{age}", arguments = listOf(navArgument("age") {
                            type =
                                NavType.IntType
                        })) { backStackEntry ->
                            Screen5(
                                navigationController,
                                backStackEntry.arguments?.getInt("age") ?: 0
                            )
                        }
                        // Pasar argumentos obligatorios like a pro
                        composable(Routes.Pantalla6.routes) { backStackEntry -> //backStackEntry es el nombre que se suele dar pero lo llamo como me da la gana
                            Screen6(
                                navigationController,
                                backStackEntry.arguments?.getString("name").orEmpty()
                            )
                        }
                        // Pasar argumentos obligatorios like a pro
                        composable(
                            Routes.Pantalla7.routes,
                            arguments = listOf(navArgument("name") {
                                defaultValue = "valor por defecto"
                            })
                        ) { backStackEntry -> //backStackEntry es el nombre que se suele dar pero lo llamo como me da la gana
                            Screen7(
                                navigationController,
                                backStackEntry.arguments?.getString("name")
                            )
                        }
                    }
                }
            }
        }
    }
}

