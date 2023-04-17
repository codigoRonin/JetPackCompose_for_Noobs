package com.example.ejercicio3_customdialog.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.ejercicio3_customdialog.R


@Composable
fun MyCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .padding(24.dp)
                    .background(Color.White)
                    .fillMaxWidth()
            )
            {
                MyTitleDialog(title = "Set backup account")
                AccountItem(email = "ejemplo1@gmail.com", R.drawable.avatar)
                AccountItem(email = "ejemplo2@gmail.com", R.drawable.avatar)
                AccountItem(email = "Add account", R.drawable.add)
            }
        }

    }
}



@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(12.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Composable
fun MyTitleDialog(title: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(12.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {

}
