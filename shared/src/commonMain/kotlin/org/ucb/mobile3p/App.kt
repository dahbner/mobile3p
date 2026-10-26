package org.ucb.mobile3p

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.ucb.mobile3p.tasks.presentation.screen.TasksScreen


@Composable
@Preview
fun App() {
    MaterialTheme {
        TasksScreen()
    }
}
