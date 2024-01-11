package com.estevan.listadetarefas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.estevan.listadetarefas.ui.theme.ListaDeTarefasTheme
import com.estevan.listadetarefas.view.SaveTask
import com.estevan.listadetarefas.view.ShowTasks

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaDeTarefasTheme {

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "ShowTasks" ){
                    composable(
                        route = "ShowTasks"
                    ){
                        ShowTasks(navController)
                    }

                    composable(
                        route = "SaveTask"
                    ){
                        SaveTask(navController)
                    }
                }
            }
        }
    }
}

