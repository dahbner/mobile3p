package org.ucb.mobile3p.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.ucb.mobile3p.notifications.presentation.viewmodel.NotificationsViewModel
import org.ucb.mobile3p.tasks.presentation.viewmodel.TasksViewModel

val presentationModule = module {
    viewModelOf(::NotificationsViewModel)  // E25-6
    viewModelOf(::TasksViewModel)          // E50-2
}
