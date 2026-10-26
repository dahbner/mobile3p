package org.ucb.mobile3p.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.ucb.mobile3p.notifications.domain.usecase.GetFcmTokenUseCase
import org.ucb.mobile3p.tasks.domain.usecase.AddTaskUseCase
import org.ucb.mobile3p.tasks.domain.usecase.ObserveCompletedCountUseCase
import org.ucb.mobile3p.tasks.domain.usecase.ObserveTasksUseCase
import org.ucb.mobile3p.tasks.domain.usecase.ToggleTaskUseCase

val domainModule = module {
    // E25-6
    singleOf(::GetFcmTokenUseCase)
    // E50-2
    singleOf(::ObserveTasksUseCase)
    singleOf(::ObserveCompletedCountUseCase)
    singleOf(::AddTaskUseCase)
    singleOf(::ToggleTaskUseCase)
}
