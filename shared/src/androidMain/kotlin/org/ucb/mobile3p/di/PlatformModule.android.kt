package org.ucb.mobile3p.di

import org.koin.core.module.Module
import org.koin.dsl.module
import org.ucb.mobile3p.config.AppDatabase
import org.ucb.mobile3p.config.getDatabaseBuilder

actual fun platformModule(): Module = module {
    single<AppDatabase> {
        getDatabaseBuilder(get())
            .fallbackToDestructiveMigration(dropAllTables = true)   // desde la Fase 15
            .build()
    }
}
