package org.ucb.mobile3p.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.ucb.mobile3p.movies.presentation.viewmodel.DollarViewModel
import org.ucb.mobile3p.signin.presentation.viewmodel.LoginViewModel
import org.ucb.mobile3p.userinformation.presentation.viewmodel.UserInformationViewModel
import org.ucb.mobile3p.exchange.presentation.viewmodel.ExchangeViewModel

val presentationModule = module {
    viewModelOf(::LoginViewModel)
    viewModelOf(::UserInformationViewModel)
    viewModelOf(::DollarViewModel)
    viewModelOf(::ExchangeViewModel)
}
