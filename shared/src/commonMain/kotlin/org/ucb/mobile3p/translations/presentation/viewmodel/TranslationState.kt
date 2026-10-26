package org.ucb.mobile3p.translations.presentation.viewmodel

data class TranslationState(
    val locale: String = "en-US",
    val texts: Map<String, String> = emptyMap()
)
