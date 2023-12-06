package com.waseokelab.week4_a

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.waseokelab.week4_a.WellnessTask


@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    list: List<WellnessTask>,
) {
    LazyColumn(modifier = modifier) {
        items(
            items = list, key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked:Boolean -> onCheckedTask(task, checked) },
                onClose = { onCloseTask(task) },
            )
        }
    }
}

fun getWellnessTasks() =
    List(30) { i -> WellnessTask(i, "Task # $i") }