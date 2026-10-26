package org.ucb.mobile3p.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.ucb.mobile3p.signin.domain.usecase.AuthenticateUseCase
import org.ucb.mobile3p.userinformation.domain.usecase.FindAliasUseCase
import org.ucb.mobile3p.exchange.domain.usecase.ObserveExchangeUseCase
import org.ucb.mobile3p.stores.domain.usecase.GetStoresUseCase
import org.ucb.mobile3p.notifications.domain.usecase.GetFcmTokenUseCase

val domainModule = module {
    singleOf(::AuthenticateUseCase)
    singleOf(::FindAliasUseCase)
    singleOf(::ObserveExchangeUseCase)
    singleOf(::GetStoresUseCase)
    singleOf(::GetFcmTokenUseCase)
}
