package org.ucb.mobile3p

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.ucb.mobile3p.localnotification.presentation.screen.LocalNotificationScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        LocalNotificationScreen()
    }
}
