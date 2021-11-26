package app.trian.todoapp.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.trian.todoapp.component.InputTodo
import app.trian.todoapp.component.TodoItem

import app.trian.todoapp.models.TodoModel
import app.trian.todoapp.ui.theme.TodoAppTheme


/*
* Page Todo
* Created at 26/11/21 19.29
* Created by Trian Damai
*/

@Composable
fun PageTodo(
    modifier: Modifier = Modifier
) {
    var itemsTodo by remember {
        mutableStateOf<List<TodoModel>>(listOf())
    }
    Scaffold(
        topBar ={
            InputTodo(saveTodo = {
                 itemsTodo = itemsTodo+TodoModel(false,it)
            })
        }
    ) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            content = {
                items(count = itemsTodo.size, itemContent = {
                        index:Int->
                    TodoItem(
                        todoModel = itemsTodo[index],
                        index = index,
                        doneTodo = {
                            index, done ->
                        }
                    ){
                        index ->
                        itemsTodo=itemsTodo-itemsTodo[index]
                    }
                })
            })
    }
}

@Preview(
    name = "preview Todo dark mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "preview Todo light mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PreviewTodo() {
    TodoAppTheme {
        PageTodo()
    }
}