package org.ucb.mobile3p.config

import androidx.room3.ConstructedBy
import androidx.room3.Database
import androidx.room3.RoomDatabase
import androidx.room3.RoomDatabaseConstructor
import org.ucb.mobile3p.movies.data.dao.DollarDao
import org.ucb.mobile3p.movies.data.entity.DollarEntity
import org.ucb.mobile3p.translations.data.dao.TranslationDao
import org.ucb.mobile3p.translations.data.entity.TranslationEntity

@Database(entities = [DollarEntity::class, TranslationEntity::class], version = 2)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): DollarDao
    abstract fun getTranslationDao(): TranslationDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("KotlinNoActualForExpect")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}
