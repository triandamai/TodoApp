package app.trian.todoapp.component

import android.content.res.Configuration
import android.widget.GridLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.trian.todoapp.ui.theme.TodoAppTheme

/*
* Input Todo
* Created at 26/11/21 19.32
* Created by Trian Damai
*/

@Composable
fun InputTodo(
    modifier: Modifier = Modifier,
    saveTodo:(todo:String)->Unit
) {
    var todo by remember {
        mutableStateOf("")
    }
    Box(
        modifier= modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ){
                TextField(
                    modifier=modifier.align(Alignment.CenterStart),
                    value = todo,
                    placeholder={
                                Text("Mau apa..")
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor=MaterialTheme.colors.primary.copy(alpha = 0.8f),
                        backgroundColor = Color.Transparent,
                        cursorColor = Color.Black,
                        disabledLabelColor = MaterialTheme.colors.background,
                        focusedIndicatorColor = MaterialTheme.colors.primary,
                        unfocusedIndicatorColor = Color.Gray
                    ),
                    onValueChange = {
                        todo = it
                    }
                )


                IconToggleButton(
                    enabled = true,
                    checked=false,
                    modifier = modifier
                        .align(Alignment.CenterEnd),
                    onCheckedChange = {
                        saveTodo(todo)
                        todo =""
                    }
                ){
                    Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add")
                }

        }

}

@Preview(
    name = "preview InputTodo dark mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "preview InputTodo light mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PreviewInputTodo() {
    TodoAppTheme {
        InputTodo(){

        }
    }
}