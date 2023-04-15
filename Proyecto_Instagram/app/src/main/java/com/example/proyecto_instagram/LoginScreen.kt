package com.example.proyecto_instagram

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Body(modifier: Modifier) {
    var userName by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Column(modifier = modifier) {
        Logo()
        Spacer(modifier = Modifier.size(16.dp))
        UserName(userName) { userName = it }
        Spacer(modifier = Modifier.size(4.dp))
        PassWord(password) { password = it }
        Spacer(modifier = Modifier.size(8.dp))
        // Tenemos que pasarle el modificador del padre directo por eso
        // creamos una instacia nueva de Modifier
        ForgotPassword(Modifier.align(Alignment.End))
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EABE9),
        modifier = modifier
    )

}

@Composable
fun PassWord(password: String, onTextChange: (String) -> Unit) {
    TextField(value = password, onValueChange = { onTextChange(it) })
}

@Composable
fun UserName(userName: String, onTextChange: (String) -> Unit) {
    TextField(value = userName, onValueChange = { onTextChange(it) })

}

@Composable
fun Logo() {
    Image(painter = painterResource(id = R.drawable.insta), contentDescription = "Logo Instagram")
}

@Composable
// Le pasamos el Modifier porque los elementos del Header como el Icon no saben que el Header
// esta en un Box
fun Header(modifier: Modifier) {
    // Vamos a coger el contexto para convertirlo a Activity y asi poder llamar a finish
    val activiy = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "close",
        modifier = modifier.clickable { activiy.finish() })
}