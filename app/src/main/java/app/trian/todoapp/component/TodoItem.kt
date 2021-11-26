package app.trian.todoapp.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.trian.todoapp.models.TodoModel
import app.trian.todoapp.ui.theme.TodoAppTheme


/*
* Todo Item
* Created at 26/11/21 19.20
* Created by Trian Damai
*/

@Composable
fun TodoItem(
    modifier: Modifier = Modifier,
    index:Int,
    todoModel: TodoModel,
    doneTodo:(index:Int,done:Boolean)->Unit,
    deleteTodo:(index:Int)->Unit
) {
    var  isDone by remember {
        mutableStateOf(todoModel.done)
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White),
    ) {
        Row (
            modifier = modifier
                .padding(vertical = 8.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            Checkbox(
                enabled=true,
                checked = isDone,
                onCheckedChange = {
                  isDone = it
                }
            )
            Spacer(modifier = modifier.width(6.dp))
            IconToggleButton(checked = false, onCheckedChange = {
                deleteTodo(index)
            }) {
                Icon(imageVector = Icons.Outlined.Delete, contentDescription = "Delete")
            }
            Spacer(modifier = modifier.width(6.dp))
            Text(
                text = todoModel.todo,
                style = TextStyle(
                    textDecoration=if(isDone) TextDecoration.LineThrough else TextDecoration.None
                )
            )
        }
    }
}

@Preview(
    name = "preview TodoItem dark mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "preview TodoItem light mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PreviewTodoItem() {
    TodoAppTheme {
        TodoItem(todoModel = TodoModel(false,""),index=0, doneTodo = {
            index, done ->
        }){
            index ->
        }
    }
}