package net.slipp.codelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TaskList(
    tasks: List<String>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(tasks) { task ->
            TaskItem(
                text = task,
                onCloseClick = {},
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun TaskListPreview() {
    val tasks = (1..100).map { "Task # $it" }
    TaskList(tasks = tasks)
}
