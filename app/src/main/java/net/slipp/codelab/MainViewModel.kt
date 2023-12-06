package net.slipp.codelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _tasks = createTasks().toMutableStateList()
    val tasks: List<Task>
        get() = _tasks.toList()

    fun remove(item: Task) {
        _tasks.remove(item)
    }

    fun replaceCompleted(task: Task, checked: Boolean) {
        val index = _tasks.indexOf(task)
        _tasks[index] = task.copy(completed = checked)
    }

    private fun createTasks(): List<Task> {
        return (1..100).map {
            return@map Task(text = "Task # $it", completed = false)
        }
    }

}
