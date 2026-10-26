package org.ucb.mobile3p.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.ucb.mobile3p.config.AppDatabase
import org.ucb.mobile3p.movies.data.dao.DollarDao
import org.ucb.mobile3p.movies.data.datasource.DollarLocalDataSource
import org.ucb.mobile3p.movies.data.repository.DollarRepositoryImpl
import org.ucb.mobile3p.movies.domain.repository.DollarRepository
import org.ucb.mobile3p.userinformation.data.datasource.GithubRemoteDataSource
import org.ucb.mobile3p.userinformation.data.repository.GithubRepositoryImpl
import org.ucb.mobile3p.userinformation.data.service.GitHubApiService
import org.ucb.mobile3p.userinformation.domain.repository.GithubRepository
import org.ucb.mobile3p.exchange.data.datasource.RealTimeDataBase
import org.ucb.mobile3p.exchange.data.repository.ExchangeRepositoryImpl
import org.ucb.mobile3p.exchange.domain.repository.ExchangeRepository
import org.ucb.mobile3p.stores.data.datasource.FirestoreDataSource
import org.ucb.mobile3p.stores.data.repository.StoresRepositoryImpl
import org.ucb.mobile3p.stores.domain.repository.StoresRepository
import org.ucb.mobile3p.notifications.data.datasource.MessagingDataSource
import org.ucb.mobile3p.notifications.data.repository.NotificationsRepositoryImpl
import org.ucb.mobile3p.notifications.domain.repository.NotificationsRepository

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
    singleOf(::FirestoreDataSource)
    single<StoresRepository> { StoresRepositoryImpl(get()) }
    singleOf(::MessagingDataSource)
    single<NotificationsRepository> { NotificationsRepositoryImpl(get()) }
}
