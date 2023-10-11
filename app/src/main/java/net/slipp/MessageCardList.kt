package net.slipp

import SampleData
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import net.slipp.model.MessageModel
import net.slipp.ui.theme.ComposeTutorialTheme

@Composable
fun MessageCardList(messages: List<MessageModel>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessageCardListPreview() {
    ComposeTutorialTheme {
        MessageCardList(SampleData.conversationSample)
    }
}
