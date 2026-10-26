package org.ucb.mobile3p.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.ucb.mobile3p.config.AppDatabase
import org.ucb.mobile3p.contact.data.datasource.RemoteConfigDataSource
import org.ucb.mobile3p.contact.data.repository.ContactRepositoryImpl
import org.ucb.mobile3p.contact.domain.repository.ContactRepository
import org.ucb.mobile3p.exchange.data.datasource.RealTimeDataBase
import org.ucb.mobile3p.exchange.data.repository.ExchangeRepositoryImpl
import org.ucb.mobile3p.exchange.domain.repository.ExchangeRepository
import org.ucb.mobile3p.log.LogService
import org.ucb.mobile3p.logs.data.config.LogsConfig
import org.ucb.mobile3p.logs.data.datasource.LogsRemoteDataSource
import org.ucb.mobile3p.logs.data.repository.LogsRepositoryImpl
import org.ucb.mobile3p.logs.domain.repository.LogsRepository
import org.ucb.mobile3p.movies.data.dao.DollarDao
import org.ucb.mobile3p.movies.data.datasource.DollarLocalDataSource
import org.ucb.mobile3p.movies.data.repository.DollarRepositoryImpl
import org.ucb.mobile3p.movies.domain.repository.DollarRepository
import org.ucb.mobile3p.notifications.data.datasource.MessagingDataSource
import org.ucb.mobile3p.notifications.data.repository.NotificationsRepositoryImpl
import org.ucb.mobile3p.notifications.domain.repository.NotificationsRepository
import org.ucb.mobile3p.stores.data.datasource.FirestoreDataSource
import org.ucb.mobile3p.stores.data.repository.StoresRepositoryImpl
import org.ucb.mobile3p.stores.domain.repository.StoresRepository
import org.ucb.mobile3p.translations.data.dao.TranslationDao
import org.ucb.mobile3p.translations.data.datasource.TranslationLocalDataSource
import org.ucb.mobile3p.translations.data.repository.TranslationRepositoryImpl
import org.ucb.mobile3p.translations.data.service.LocoApiService
import org.ucb.mobile3p.translations.domain.repository.TranslationRepository
import org.ucb.mobile3p.userinformation.data.datasource.GithubRemoteDataSource
import org.ucb.mobile3p.userinformation.data.repository.GithubRepositoryImpl
import org.ucb.mobile3p.userinformation.data.service.GitHubApiService
import org.ucb.mobile3p.userinformation.domain.repository.GithubRepository
import org.ucb.mobile3p.tasks.data.datasource.TasksFirebaseDataSource
import org.ucb.mobile3p.tasks.data.repository.TasksRepositoryImpl
import org.ucb.mobile3p.tasks.domain.repository.TasksRepository

val dataModule = module {
    single<GithubRemoteDataSource> { GitHubApiService() }
    single<GithubRepository>{GithubRepositoryImpl(get())}
    single<DollarDao> {
        get<AppDatabase>().getDao()
    }
    singleOf(::DollarLocalDataSource)
    single<DollarRepository> { DollarRepositoryImpl(get()) }
    singleOf(::RealTimeDataBase)
    single<ExchangeRepository> { ExchangeRepositoryImpl(get()) }
    // Fase 9
    singleOf(::FirestoreDataSource)
    single<StoresRepository> { StoresRepositoryImpl(get()) }
    // Fase 10
    singleOf(::MessagingDataSource)
    single<NotificationsRepository> { NotificationsRepositoryImpl(get()) }
    // Fase 11
    single { LogService(LogsConfig.BASE_URL) }
    single { LogsRemoteDataSource(get()) }
    single<LogsRepository> { LogsRepositoryImpl(get()) }
    // Fase 13
    single<RemoteConfigDataSource> { RemoteConfigDataSource() }
    single<ContactRepository> { ContactRepositoryImpl(get()) }
    // Fase 15
    single { LocoApiService() }
    single<TranslationDao> { get<AppDatabase>().getTranslationDao() }
    singleOf(::TranslationLocalDataSource)
    single<TranslationRepository> { TranslationRepositoryImpl(get(), get()) }
    singleOf(::TasksFirebaseDataSource)
    single<TasksRepository> { TasksRepositoryImpl(get()) }
}
