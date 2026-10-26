package org.ucb.mobile3p.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.ucb.mobile3p.signin.presentation.viewmodel.LoginViewModel

val presentationModule = module {
    viewModelOf(::LoginViewModel)
}
