package org.ucb.mobile3p.translations.data.datasource

import org.ucb.mobile3p.translations.data.dao.TranslationDao
import org.ucb.mobile3p.translations.data.entity.TranslationEntity

class TranslationLocalDataSource(
    val dao: TranslationDao
) {
    suspend fun save(locale: String, texts: Map<String, String>) {
        dao.insertAll(texts.map { TranslationEntity(locale = locale, key = it.key, value = it.value) })
    }

    suspend fun getList(locale: String): Map<String, String> {
        return dao.getByLocale(locale).associate { it.key to it.value }
    }

    suspend fun find(locale: String, key: String): String? {
        return dao.find(locale, key)?.value
    }
}
