package com.estevan.listadetarefas.taskItem

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.estevan.listadetarefas.R
import androidx.constraintlayout.widget.ConstraintLayout
import com.estevan.listadetarefas.model.Task

@Composable
fun TaskItem(
    position: Int,
    taskList: MutableList<Task>
){

    val taskTitle = taskList[position].name
    val taskDescription = taskList[position].description
    val taskPriority = taskList[position].priority

    var priorityLevel: String = when(taskPriority){
        0 -> {
            "Without priority"
        }
        1 -> {
            "Low priority"
        }
        2 -> {
            "Medium priority"
        }
        else -> {
            "High priority"
        }
    }

    val color = when(taskPriority){
        0 -> {
            Color.Black
        }
        1 -> {
            Color.Green
        }
        2 -> {
            Color.Yellow
        }
        else -> {
            Color.Red
        }
    }

    Card(
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
    ){

        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {

            val(txtTitle, txtDescription, cardPriority, txtPriority, btnDelete) = createRefs()

            Text(
                text = taskTitle.toString(),
                modifier = Modifier.constrainAs(txtTitle){
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = taskDescription.toString(),
                modifier = Modifier.constrainAs(txtDescription){
                    top.linkTo(txtTitle.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = priorityLevel.toString(),
                modifier = Modifier.constrainAs(txtPriority){
                    top.linkTo(txtDescription.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            )

            Card(
                colors = CardDefaults.cardColors(color),
                modifier = Modifier
                    .size(30.dp)
                    .constrainAs(cardPriority) {
                        top.linkTo(txtDescription.bottom, margin = 10.dp)
                        start.linkTo(txtPriority.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                    },
                shape = CircleShape
            ) {
            }

            IconButton(
                onClick = {/*TODO*/ },
                modifier = Modifier.constrainAs(btnDelete){
                    top.linkTo(txtDescription.bottom, margin = 10.dp)
                    start.linkTo(cardPriority.end, margin = 30.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete_24), contentDescription = null)
            }
        }

    }

}

/*
@Composable
private fun TaskItemPreview(){
    TaskItem()
}*/
