package com.example.proyecto_instagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyecto_instagram.login.ui.LoginViewModel
import com.example.proyecto_instagram.login.ui.LoginScreen
import com.example.proyecto_instagram.ui.theme.Proyecto_InstagramTheme
import dagger.hilt.android.AndroidEntryPoint

// La idea de la inyeccion de dependencias es que no haya ninguna instancia fuera de la
// inyeccion de dependencias ( ViewModels, caso de uso, ...)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto_InstagramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   LoginScreen(loginViewModel= loginViewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Proyecto_InstagramTheme {

    }
}