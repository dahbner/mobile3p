package org.ucb.mobile3p.translations.domain.usecase

import org.ucb.mobile3p.translations.domain.repository.TranslationRepository

class SyncTranslationsUseCase(
    val repository: TranslationRepository
) {
    suspend fun invoke(locale: String): Map<String, String> {
        return repository.sync(locale)
    }
}
