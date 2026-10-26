package org.ucb.mobile3p.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.ucb.mobile3p.contact.domain.usecase.GetContactUseCase
import org.ucb.mobile3p.exchange.domain.usecase.ObserveExchangeUseCase
import org.ucb.mobile3p.exchange.domain.usecase.SaveEventUseCase
import org.ucb.mobile3p.logs.domain.usecase.SendLogUseCase
import org.ucb.mobile3p.notifications.domain.usecase.GetFcmTokenUseCase
import org.ucb.mobile3p.signin.domain.usecase.AuthenticateUseCase
import org.ucb.mobile3p.stores.domain.usecase.GetStoresUseCase
import org.ucb.mobile3p.translations.domain.usecase.SyncTranslationsUseCase
import org.ucb.mobile3p.translations.domain.usecase.TranslateUseCase
import org.ucb.mobile3p.userinformation.domain.usecase.FindAliasUseCase
import org.ucb.mobile3p.tasks.domain.usecase.AddTaskUseCase
import org.ucb.mobile3p.tasks.domain.usecase.ObserveCompletedCountUseCase
import org.ucb.mobile3p.tasks.domain.usecase.ObserveTasksUseCase
import org.ucb.mobile3p.tasks.domain.usecase.ToggleTaskUseCase

val domainModule = module {
    singleOf(::AuthenticateUseCase)
    singleOf(::FindAliasUseCase)
    singleOf(::ObserveExchangeUseCase)
    singleOf(::GetStoresUseCase)          // Fase 9
    singleOf(::GetFcmTokenUseCase)        // Fase 10
    singleOf(::SendLogUseCase)            // Fase 11
    singleOf(::GetContactUseCase)         // Fase 13
    singleOf(::SaveEventUseCase)          // Fase 14
    singleOf(::SyncTranslationsUseCase)   // Fase 15
    singleOf(::TranslateUseCase)          // Fase 15
    singleOf(::ObserveTasksUseCase)
    singleOf(::ObserveCompletedCountUseCase)
    singleOf(::AddTaskUseCase)
    singleOf(::ToggleTaskUseCase)
}
