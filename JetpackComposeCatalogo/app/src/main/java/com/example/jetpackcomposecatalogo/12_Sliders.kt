package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyBasicSlider() {
    var sliderPosition by remember { mutableStateOf(0f) }

    Column(Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun MyAdvanceSlider() {
    var sliderPosition by rememberSaveable { mutableStateOf(0f) }
    var sliderFinishedPosition by rememberSaveable { mutableStateOf("") }
    Column(Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            enabled = true,
            valueRange = 0f..10f,
            steps = 9,  // Siempre hay que restar 2 en este caso el 0 y el 10
            onValueChangeFinished = { sliderFinishedPosition = sliderPosition.toString() }
        )
        Text(text = sliderFinishedPosition)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {
    var currentRange by remember { mutableStateOf(0f..10f) }
    Column(Modifier.padding(24.dp)) {
        RangeSlider(
            values = currentRange, onValueChange = { currentRange = it },
            valueRange = 0f..10f,
            steps = 9
        )

        Text(text = "Valor inferior ${currentRange.start.toString()}")
        Text(text = "Valor Superior ${currentRange.endInclusive.toString()}")
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyPreviewSlider() {
    //MyBasicSlider()
    //MyAdvanceSlider()
    MyRangeSlider()
}