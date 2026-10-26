package org.ucb.mobile3p.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.ucb.mobile3p.notifications.data.datasource.MessagingDataSource
import org.ucb.mobile3p.notifications.data.repository.NotificationsRepositoryImpl
import org.ucb.mobile3p.notifications.domain.repository.NotificationsRepository
import org.ucb.mobile3p.tasks.data.datasource.TasksFirebaseDataSource
import org.ucb.mobile3p.tasks.data.repository.TasksRepositoryImpl
import org.ucb.mobile3p.tasks.domain.repository.TasksRepository

val dataModule = module {
    // E25-6: token FCM
    singleOf(::MessagingDataSource)
    single<NotificationsRepository> { NotificationsRepositoryImpl(get()) }
    // E50-2: tareas (Firestore) + contador (Realtime Database)
    singleOf(::TasksFirebaseDataSource)
    single<TasksRepository> { TasksRepositoryImpl(get()) }
}
