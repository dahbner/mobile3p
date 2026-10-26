package org.ucb.mobile3p.translations.data.dao

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import org.ucb.mobile3p.translations.data.entity.TranslationEntity

@Dao
interface TranslationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<TranslationEntity>)

    @Query("SELECT * FROM translations WHERE locale = :locale")
    suspend fun getByLocale(locale: String): List<TranslationEntity>

    @Query("SELECT * FROM translations WHERE locale = :locale AND `key` = :key LIMIT 1")
    suspend fun find(locale: String, key: String): TranslationEntity?
}
