package com.estevan.listadetarefas.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.estevan.listadetarefas.ui.theme.Purple40
import com.estevan.listadetarefas.ui.theme.PurpleGrey40
import com.estevan.listadetarefas.ui.theme.PurpleGrey80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextBox(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int,
    keyboardType: KeyboardType
){
    OutlinedTextField(
        value = value,
        onValueChange,
        modifier,
        label = {
            Text(text = label )
        },
        maxLines = maxLines,
        textStyle = TextStyle(color = Color.Black),
        colors = TextFieldDefaults.colors(
            cursorColor = Color.Blue,
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.White,
            unfocusedContainerColor = PurpleGrey40,
            focusedContainerColor = PurpleGrey80
        ),
        shape = RoundedCornerShape(20.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}

