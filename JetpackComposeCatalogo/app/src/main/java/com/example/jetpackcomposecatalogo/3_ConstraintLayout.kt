package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun ConstraintLayoutExample() {

    ConstraintLayout(Modifier.fillMaxSize()) {

        val (redBox, yellowBox, greenBox) = createRefs()

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
                .width(125.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    bottom.linkTo(redBox.top)
                    end.linkTo(redBox.start)
                })
        Box(
            Modifier
                .size(125.dp)
                .width(125.dp)
                .background(Color.Green)
                .constrainAs(greenBox) {
                    bottom.linkTo(redBox.top)
                    start.linkTo(redBox.end)
                })

    }

}

@Composable
fun ConstraintLayoutGuide() {

    ConstraintLayout(Modifier.fillMaxSize()) {

        val redBox = createRef()
//      val startGuideLine = createGuidelineFromStart(16.dp)
        val topGuideline = createGuidelineFromTop(25.dp)
        val startGuideLine = createGuidelineFromStart(0.1f) // 10%

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    start.linkTo(startGuideLine)
                    top.linkTo(topGuideline)
                })

    }

}

@Composable
fun ConstraintLayoutBarrier() {

    ConstraintLayout(Modifier.fillMaxSize()) {

        val (boxRed, boxGreen, boxYellow) = createRefs()

        // Se crea un espacio personal (Barrera) que aunque cambie de tamaño en tiempo
        // de ejecución ningun componente podrá atraversarlo.
        // Puede ser util para vistas que cambian dinamicamente para que ningun componente descuadre.
        val barrier = createEndBarrier(boxRed, boxGreen)

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    start.linkTo(parent.start, margin = 16.dp)

                })
        Box(
            Modifier
                .size(250.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    start.linkTo(parent.start, margin = 32.dp)
                    top.linkTo(boxRed.bottom)
                })
        Box(
            Modifier
                .size(50.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(barrier)
                })

    }

}

@Composable
fun ConstraintLayoutChain() {

    ConstraintLayout(Modifier.fillMaxSize()) {

        val (boxRed, boxGreen, boxYellow) = createRefs()

        Box(
            Modifier
                .size(75.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    start.linkTo(parent.start)
                    end.linkTo(boxGreen.start)
                })
        Box(
            Modifier
                .size(75.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    start.linkTo(boxRed.end)
                    end.linkTo(boxYellow.start)

                })
        Box(
            Modifier
                .size(75.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(boxGreen.end)
                    end.linkTo(parent.end)
                })

        //   createHorizontalChain(boxRed,boxGreen,boxYellow, chainStyle = ChainStyle.Packed)
        //   Por defecto
        //   createHorizontalChain(boxRed,boxGreen,boxYellow, chainStyle = ChainStyle.Spread)
        createHorizontalChain(boxRed, boxGreen, boxYellow, chainStyle = ChainStyle.SpreadInside)

        //  createVerticalChain(boxRed, boxGreen, boxYellow, chainStyle = ChainStyle.SpreadInside)

    }
}


@Preview(name = "Ejemplo Chain", showSystemUi = true, showBackground = true)
@Composable
fun PreviewExample4() {
    ConstraintLayoutChain()
}

@Preview(name = "Ejemplo Barrier", showSystemUi = true, showBackground = true)
@Composable
fun PreviewExample3() {
    ConstraintLayoutBarrier()
}

@Preview(name = "Ejemplo Guide", showSystemUi = true, showBackground = true)
@Composable
fun PreviewExample2() {
    ConstraintLayoutGuide()
}

@Preview(name = "Ejemplo 1", showSystemUi = true, showBackground = true)
@Composable
fun PreviewExample1() {
    ConstraintLayoutExample()
}