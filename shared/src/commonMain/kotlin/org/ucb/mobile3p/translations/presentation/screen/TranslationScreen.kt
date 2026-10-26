package org.ucb.mobile3p.translations.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import edu.ucb.ds.buttons.MainButton
import org.koin.compose.viewmodel.koinViewModel
import org.ucb.mobile3p.translations.presentation.viewmodel.TranslationEvent
import org.ucb.mobile3p.translations.presentation.viewmodel.TranslationViewModel

@Composable
fun TranslationScreen(viewModel: TranslationViewModel = koinViewModel()) {
    val state = viewModel.state.collectAsState()

    Column {
        TextField(value = state.value.locale, onValueChange = {
            viewModel.emitEvent(TranslationEvent.OnLocaleChange(it))
        })
        MainButton("Descargar traducciones") {
            viewModel.emitEvent(TranslationEvent.OnSync)
        }
        state.value.texts.forEach { (key, value) ->
            Text("$key = $value")
        }
    }
}
