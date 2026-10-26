package org.ucb.mobile3p.translations.domain.repository

interface TranslationRepository {
    suspend fun sync(locale: String): Map<String, String>
    suspend fun translate(locale: String, key: String): String?
}
