package org.ucb.mobile3p

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.ucb.mobile3p.notifications.presentation.screen.NotificationsScreen

@Composable
@Preview
fun App(messageId: String? = null) {
    MaterialTheme {
        Column(modifier = Modifier.safeContentPadding()) {
            Text(
                text = "message_id: ${messageId ?: "(app abierta normal)"}",
                modifier = Modifier.padding(16.dp)
            )

            NotificationsScreen()
        }
    }
}