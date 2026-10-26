package org.ucb.mobile3p.translations.presentation.viewmodel

sealed interface TranslationEvent {
    data class OnLocaleChange(val value: String): TranslationEvent
    object OnSync: TranslationEvent
}
