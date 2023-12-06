package net.slipp.codelab

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

data class Task(val text: String, val completed: Boolean)

@Composable
fun TaskListScreen(viewModel: MainViewModel = viewModel()) {
    val tasks = viewModel.tasks
    TaskList(
        tasks = tasks,
        onCloseClick = viewModel::remove,
        onCheckedChange = { task, checked ->
            viewModel.replaceCompleted(task, checked)
        }
    )
}

@Composable
fun TaskList(
    tasks: List<Task>,
    onCloseClick: (Task) -> Unit,
    onCheckedChange: (Task, Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(tasks) { task ->
            TaskItem(
                task = task,
                onCloseClick = { onCloseClick(task) },
                onCheckedChange = { checked ->
                    onCheckedChange(task, checked)
                },
            )
        }
    }
}

@Composable
private fun TaskItem(
    task: Task,
    onCloseClick: () -> Unit,
    onCheckedChange: (Boolean) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Text(
            text = task.text,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Checkbox(checked = task.completed, onCheckedChange = onCheckedChange)
        IconButton(onClick = onCloseClick) {
            Icon(imageVector = Icons.Outlined.Close, contentDescription = null)
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun TaskListScreenPreview() {
    TaskListScreen()
}
