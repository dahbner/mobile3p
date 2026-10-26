package org.ucb.mobile3p.translations.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ucb.mobile3p.translations.domain.usecase.SyncTranslationsUseCase

class TranslationViewModel(
    val syncTranslationsUseCase: SyncTranslationsUseCase
): ViewModel() {

    private val _state = MutableStateFlow(TranslationState())
    val state = _state.asStateFlow()

    fun emitEvent(event: TranslationEvent) {
        when(event) {
            is TranslationEvent.OnLocaleChange -> {
                _state.update { it.copy(locale = event.value) }
            }
            TranslationEvent.OnSync -> {
                viewModelScope.launch {
                    val texts = syncTranslationsUseCase.invoke(_state.value.locale)
                    _state.update { it.copy(texts = texts) }
                }
            }
        }
    }
}
