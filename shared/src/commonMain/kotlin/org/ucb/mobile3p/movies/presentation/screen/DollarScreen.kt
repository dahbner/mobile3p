package org.ucb.mobile3p.movies.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel
import org.ucb.mobile3p.movies.presentation.viewmodel.DollarEvent
import org.ucb.mobile3p.movies.presentation.viewmodel.DollarViewModel

@Composable
fun DollarScreen(
    viewModel: DollarViewModel = koinViewModel()
) {
    val state = viewModel.state.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
                viewModel.emitEvent(DollarEvent.OnAddRecord)
        }) {
            Text("Add")
        }
        Text(state.value.list.size.toString())
    }

}
