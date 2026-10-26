package org.ucb.mobile3p.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.ucb.mobile3p.signin.domain.usecase.AuthenticateUseCase
import org.ucb.mobile3p.userinformation.domain.usecase.FindAliasUseCase

val domainModule = module {
    singleOf(::AuthenticateUseCase)
    singleOf(::FindAliasUseCase)
}
