package org.ucb.mobile3p.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.ucb.mobile3p.signin.domain.usecase.AuthenticateUseCase

val domainModule = module {
    singleOf(::AuthenticateUseCase)
}
