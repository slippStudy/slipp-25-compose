package net.slipp.codelab

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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

@Composable
fun TaskItem(text: String, onCloseClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Checkbox(checked = true, onCheckedChange = {})
        IconButton(onClick = onCloseClick) {
            Icon(imageVector = Icons.Outlined.Close, contentDescription = null)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskItemPreview() {
    TaskItem(
        onCloseClick = {},
        text = "Have you taken"
    )
}
