package org.ucb.mobile3p.translations.data.repository

import org.ucb.mobile3p.translations.data.datasource.TranslationLocalDataSource
import org.ucb.mobile3p.translations.data.service.LocoApiService
import org.ucb.mobile3p.translations.domain.repository.TranslationRepository

class TranslationRepositoryImpl(
    val remote: LocoApiService,
    val local: TranslationLocalDataSource
): TranslationRepository {
    // Descarga de localise.biz y guarda en Room; si no hay internet, devuelve lo guardado
    override suspend fun sync(locale: String): Map<String, String> {
        return try {
            val texts = remote.getTranslations(locale)
            local.save(locale, texts)
            texts
        } catch (e: Exception) {
            local.getList(locale)
        }
    }

    override suspend fun translate(locale: String, key: String): String? {
        return local.find(locale, key)
    }
}
