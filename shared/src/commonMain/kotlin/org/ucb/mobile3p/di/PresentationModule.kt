package org.ucb.mobile3p.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.ucb.mobile3p.contact.presentation.viewmodel.ContactViewModel
import org.ucb.mobile3p.exchange.presentation.viewmodel.ExchangeViewModel
import org.ucb.mobile3p.logs.presentation.viewmodel.LogsViewModel
import org.ucb.mobile3p.movies.presentation.viewmodel.DollarViewModel
import org.ucb.mobile3p.notifications.presentation.viewmodel.NotificationsViewModel
import org.ucb.mobile3p.signin.presentation.viewmodel.LoginViewModel
import org.ucb.mobile3p.stores.presentation.viewmodel.StoresViewModel
import org.ucb.mobile3p.translations.presentation.viewmodel.TranslationViewModel
import org.ucb.mobile3p.userinformation.presentation.viewmodel.UserInformationViewModel
import org.ucb.mobile3p.tasks.presentation.viewmodel.TasksViewModel

val presentationModule = module {
    viewModelOf(::LoginViewModel)
    viewModelOf(::UserInformationViewModel)
    viewModelOf(::DollarViewModel)
    viewModelOf(::ExchangeViewModel)
    viewModelOf(::StoresViewModel)         // Fase 9
    viewModelOf(::NotificationsViewModel)  // Fase 10
    viewModelOf(::LogsViewModel)           // Fase 11
    viewModelOf(::ContactViewModel)        // Fase 13
    viewModelOf(::TranslationViewModel)    // Fase 15
    viewModelOf(::TasksViewModel)
}
