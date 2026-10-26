package org.ucb.mobile3p

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.ucb.mobile3p.exchange.presentation.screen.ExchangeScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        ExchangeScreen()
    }
}
