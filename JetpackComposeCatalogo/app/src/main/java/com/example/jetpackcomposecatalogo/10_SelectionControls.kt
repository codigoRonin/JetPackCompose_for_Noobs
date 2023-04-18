package com.example.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.model.CheckInfo
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class SelectionControls : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var status by rememberSaveable { mutableStateOf(false) }
                    val checkInfo = CheckInfo(
                        title = "Este es el bueno",
                        selected = status,
                        // onCheckedChange = {status = it}
                        onCheckedChange = { myNewStatus -> status = myNewStatus }
                    )

                    val myOptions = getOptions(listOf("Opcion 1", "Opcion 2", "Opcion 3"))


                    var selected by rememberSaveable { mutableStateOf("Hombre") }

                    Column {
                        MyCheckBoxWithText()
                        MyCheckBoxWithTextCompleted(checkInfo = checkInfo)
                        MyTriStateCheckBox()
                        myOptions.forEach { MyCheckBoxWithTextCompleted(checkInfo = it) }
                        MyRadioButtonList()
                        MyRadioButtonListStateHoisting(selected) { selected = it }
                    }
                }
            }
        }
    }
}

@Composable
fun MySwitchExample() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Green,
            checkedThumbColor = Color.Magenta,
            checkedTrackColor = Color.Blue,
            checkedTrackAlpha = 0.5f,
            uncheckedTrackAlpha = 0.5f,
            disabledCheckedTrackColor = Color.Yellow,
            disabledCheckedThumbColor = Color.Yellow,
            disabledUncheckedThumbColor = Color.Gray,
            disabledUncheckedTrackColor = Color.Gray
        )
    )
}

@Composable
fun MyCheckBoxExample() {
    var state by rememberSaveable { mutableStateOf(false) }

    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Green
        )
    )
}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo 1")
    }
}

// Problemas -> Que pasaría si quisieramos tener un listado de checkBox, si tuvieramos 10 checkBox
// Habría que tener 10 estados  ->  var state by rememberSaveable { mutableStateOf(false) }
// -> muy poco funcional
// Solucion creamos una data class (como los struct de otros lenguajes) para guardar la info de los
// checkBox pero no se puede pasar a un mutableStateOf un objeto
@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

// Creamos una función que va a recibir un listado de nombres y devolverá un listadp
// de Checkinfo con esos nombres.
@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {

    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            // onCheckedChange = {status = it}
            onCheckedChange = { myNewStatus -> status = myNewStatus }
        )
    }
}

@Composable
fun MyTriStateCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> {
                ToggleableState.Off
                //Podriamos hacer mas acciones como por ejemplo activar hijos, borrar algo, ...
            }
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })


}

@Composable
fun MyRadioButtonExample() {
    Row() {
        RadioButton(
            selected = false, onClick = {}, enabled = true, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Green,
                disabledColor = Color.Blue
            )
        )

        Text("Ejemplo de radio")
    }
}


@Composable
fun MyRadioButtonList() {

    var selected by rememberSaveable { mutableStateOf("Hombre") }

    Column(Modifier.fillMaxWidth()) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selected == "Hombre", onClick = { selected = "Hombre" })
            Text("Hombre")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selected == "Mujer", onClick = { selected = "Mujer" })
            Text("Mujer")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selected == "No Binario", onClick = { selected = "No Binario" })
            Text("No Binario")
        }

    }
}
@Composable
fun MyRadioButtonListStateHoisting(name: String, onItemSelected: (String) -> Unit) {

    Column(Modifier.fillMaxWidth()) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Hombre", onClick = { onItemSelected("Hombre") })
            Text("Hombre")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Mujer", onClick = { onItemSelected("Mujer") })
            Text("Mujer")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "No Binario", onClick = { onItemSelected("No Binario") })
            Text("No Binario")
        }

    }
}

@Preview(name = "Ejemplo de RadioButton", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewRadioButton() {
    MyRadioButtonExample()
}

@Preview(name = "Ejemplo de CheckBob Tristate", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewTriSate() {
    MyTriStateCheckBox()
}

@Preview(name = "Ejemplo de Checkbox con texto", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewCheckBox2() {
    //Lo meto dentro de una columna para poder alinear la fila centrada verticalmente
    Column() {
        MyCheckBoxWithText()
        MyCheckBoxWithText()
        MyCheckBoxWithText()
    }
}

@Preview(name = "Ejemplo de Checkbox", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewCheckBox1() {
    MyCheckBoxExample()
}

@Preview(name = "Ejemplo de Switch", showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewSwitch() {
    MySwitchExample()
}