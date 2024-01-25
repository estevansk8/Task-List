package com.estevan.listadetarefas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.estevan.listadetarefas.components.TextBox
import com.estevan.listadetarefas.ui.theme.Purple40
import com.estevan.listadetarefas.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaveTask(
    navController: NavHostController
){

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple40
                ),
                title = {
                    Text(
                        text = "Save Task",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = White
                    )
                }
            )
        }
    ) {

        var titleTask by remember{
            mutableStateOf("")
        }

        var descriptionOfTask by remember {
            mutableStateOf("")
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ){
            TextBox(
                value = titleTask,
                onValueChange = {titleTask = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label = "Task Title",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )

            TextBox(
                value = descriptionOfTask,
                onValueChange = {descriptionOfTask = it},
                modifier = Modifier
                    .fillMaxWidth().height(160.dp)
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Description",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )
        }
    }
}