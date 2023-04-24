package com.example.jetpackcomposecatalogo

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coronavirus
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

@Composable
fun ColorAnimationSimple() {

    Column(Modifier.fillMaxSize()) {
        var firstColor by rememberSaveable { mutableStateOf(false) }
        var realColor = if (firstColor) Color.Red else Color.Cyan

        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { firstColor = !firstColor })

        Spacer(modifier = Modifier.size(100.dp))

        var secondColor by rememberSaveable { mutableStateOf(false) }
        val realSecondColor by animateColorAsState(targetValue = if (secondColor) Color.Red else Color.Cyan)

        Box(modifier = Modifier
            .size(100.dp)
            .background(realSecondColor)
            .clickable { secondColor = !secondColor })

    }

}

@Composable
fun ColorAnimationAdvance() {

    var firstColor by rememberSaveable { mutableStateOf(false) }
    val realColor by animateColorAsState(
        targetValue = if (firstColor) Color.Red else Color.Cyan,
        animationSpec = tween(3000)
    )

    Box(modifier = Modifier
        .size(100.dp)
        .background(realColor)
        .clickable { firstColor = !firstColor })
}

@Composable
fun ColorAnimationAdvanceDisappear() {

    var firstColor by rememberSaveable { mutableStateOf(false) }
    var showBox by rememberSaveable { mutableStateOf(true) }
    val realColor by animateColorAsState(
        targetValue = if (firstColor) Color.Red else Color.Cyan,
        animationSpec = tween(3000),
        finishedListener = { showBox = false }
    )

    if (showBox) {
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { firstColor = !firstColor })
    }
}

@Composable
fun SizeAnimationBasic() {
    var smallSize by rememberSaveable { mutableStateOf(false) }
    // val size = if (smallSize) 50.dp else 100.dp
    val size by animateDpAsState(targetValue = if (smallSize) 50.dp else 100.dp)

    Box(modifier = Modifier
        .size(size)
        .background(Color.Green)
        .clickable { smallSize = !smallSize })

}

@Composable
fun SizeAnimationAdvance() {
    var smallSize by rememberSaveable { mutableStateOf(false) }
    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(1000),
        finishedListener = {}
    )

    Box(modifier = Modifier
        .size(size)
        .background(Color.Green)
        .clickable { smallSize = !smallSize })

}

@Composable
fun VisibilityAnimationSimple() {
    var isVisible by rememberSaveable { mutableStateOf(false) }

    Column(Modifier.fillMaxSize()) {

        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Mostrar/Ocultar")
        }
        Spacer(modifier = Modifier.size(50.dp))
        // if (isVisible) {
        AnimatedVisibility(visible = isVisible) {
            Box(
                Modifier
                    .size(150.dp)
                    .background(Color.Cyan)
            )
        }

    }
}

@Composable
fun VisibilityAnimationAdvance() {
    var isVisible by rememberSaveable { mutableStateOf(false) }

    Column(Modifier.fillMaxSize()) {

        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Mostrar/Ocultar")
        }
        Spacer(modifier = Modifier.size(50.dp))
        // if (isVisible) {
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally()
        ) {
            Box(
                Modifier
                    .size(150.dp)
                    .background(Color.Cyan)
            )
        }

    }
}

@Composable
fun CrossfadeAnimation() {
    var myComponentType: ComponentType by rememberSaveable { mutableStateOf(ComponentType.Text) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(48.dp)
    ) {

        Button(onClick = { myComponentType = getRandomComponentType() }) {
            Text(text = "Mostar Componente")
        }
        Crossfade(targetState = myComponentType) {
            when (it) {
                ComponentType.Text -> Text(text = "Soy un componente de tipo texto")
                ComponentType.Image -> Icon(
                    imageVector = Icons.Default.Coronavirus,
                    contentDescription = "Virus"
                )
                ComponentType.Box -> Box(
                    modifier = Modifier
                        .size(150.dp)
                        .background(Color.Magenta)
                )
                ComponentType.Error -> Text(text = "Soy un Error")
            }
        }

    }
}

fun getRandomComponentType(): ComponentType {
    return when (nextInt(from = 0, until = 3)) {
        0 -> ComponentType.Text
        1 -> ComponentType.Image
        2 -> ComponentType.Box
        else -> ComponentType.Error
    }
}

enum class ComponentType() {
    Image, Text, Box, Error
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyAnimationPreview() {
    //ColorAnimationSimple()
    //ColorAnimationAdvance()
    //ColorAnimationAdvanceDisappear()
    //SizeAnimationBasic()
    //SizeAnimationAdvance()
    // VisibilityAnimationSimple()
    //VisibilityAnimationAdvance()
    CrossfadeAnimation()
}