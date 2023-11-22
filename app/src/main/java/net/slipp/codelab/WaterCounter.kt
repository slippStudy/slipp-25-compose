package net.slipp.codelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatefulWaterCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessWaterCounter(
        count = count,
        onIncrementClick = { count++ },
        modifier = modifier,
    )
}

@Composable
fun StatelessWaterCounter(
    count: Int,
    onIncrementClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(text = "You've had $count glasses.")
        }

        Button(
            onClick = onIncrementClick,
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp),
        ) {
            Text(text = "Add one!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StatefulWaterCounterPreview() {
    StatefulWaterCounter()
}
