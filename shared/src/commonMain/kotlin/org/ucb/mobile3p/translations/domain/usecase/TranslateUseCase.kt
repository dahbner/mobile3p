package org.ucb.mobile3p.translations.domain.usecase

import org.ucb.mobile3p.translations.domain.repository.TranslationRepository

class TranslateUseCase(
    val repository: TranslationRepository
) {
    // Si todavía no está guardada, devuelve la clave
    suspend fun invoke(locale: String, key: String): String {
        return repository.translate(locale, key) ?: key
    }
}
