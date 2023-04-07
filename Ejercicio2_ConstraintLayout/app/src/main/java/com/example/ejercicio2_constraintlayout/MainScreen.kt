package com.example.ejercicio2_constraintlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.ejercicio2_constraintlayout.ui.theme.Ejercicio2_ConstraintLayoutTheme

@Composable
fun ConstrainLayoutExercice() {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (redBox, greenBox, yellowBox, cyanBox, bluebox) = createRefs()

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                })
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Green)
                .constrainAs(greenBox) {
                    bottom.linkTo(redBox.top)
                    end.linkTo(redBox.start)

                })
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    bottom.linkTo(redBox.top)
                    start.linkTo(redBox.end)
                })
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Cyan)
                .constrainAs(cyanBox) {
                    top.linkTo(redBox.bottom)
                    end.linkTo(redBox.start)
                })
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Blue)
                .constrainAs(bluebox) {
                    top.linkTo(redBox.bottom)
                    start.linkTo(redBox.end)
                })

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Ejercicio2_ConstraintLayoutTheme {
        ConstrainLayoutExercice()
    }
}