package com.estevan.listadetarefas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.estevan.listadetarefas.R
import com.estevan.listadetarefas.ui.theme.Black
import com.estevan.listadetarefas.ui.theme.Purple40
import com.estevan.listadetarefas.ui.theme.Purple80
import com.estevan.listadetarefas.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowTasks(
    navController: NavController
){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple40
                ),
                title = { 
                    Text(
                        text = "Task List ",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = White
                    )
                }
            )
        },
        containerColor = Black,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                },
                containerColor = Purple40,
                shape = ShapeDefaults.ExtraLarge
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_add),
                    contentDescription = "icon to save task")
            }
        }

    ) {

    }
}