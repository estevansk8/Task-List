package com.estevan.listadetarefas.view

import android.annotation.SuppressLint
import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.estevan.listadetarefas.components.CustomButton
import com.estevan.listadetarefas.components.TextBox
import com.estevan.listadetarefas.ui.theme.HardPriorityDisabled
import com.estevan.listadetarefas.ui.theme.HardPrioritySelected
import com.estevan.listadetarefas.ui.theme.LowPriorityDisabled
import com.estevan.listadetarefas.ui.theme.LowPrioritySelected
import com.estevan.listadetarefas.ui.theme.MediumPriorityDisabled
import com.estevan.listadetarefas.ui.theme.MediumPrioritySelected
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

        var lowPriority by remember {
            mutableStateOf(false)
        }

        var mediumPriority by remember {
            mutableStateOf(false)
        }

        var hardPriority by remember{
            mutableStateOf(false)
        }

        var urgentPriority by remember {
            mutableStateOf(false)
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
                    .padding(20.dp, 70.dp, 20.dp, 0.dp),
                label = "Task Title",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )

            TextBox(
                value = descriptionOfTask,
                onValueChange = {descriptionOfTask = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Description",
                maxLines = 5,
                keyboardType = KeyboardType.Text
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Priority Level")
                
                RadioButton(
                    selected = lowPriority,
                    onClick = { lowPriority = !lowPriority },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = LowPriorityDisabled,
                        selectedColor = LowPrioritySelected
                    )
                )

                RadioButton(
                    selected = mediumPriority,
                    onClick = { mediumPriority = !mediumPriority },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = MediumPriorityDisabled,
                        selectedColor = MediumPrioritySelected
                    )
                )

                RadioButton(
                    selected = hardPriority,
                    onClick = { hardPriority = !hardPriority },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = HardPriorityDisabled,
                        selectedColor = HardPrioritySelected
                    )
                )
            }
            
            CustomButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth().height(130.dp).padding(20.dp),
                text = "Save"
            )
        }
    }
}