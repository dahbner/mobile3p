package org.ucb.mobile3p.di

import org.koin.core.module.Module

fun sharedModule(): List<Module> = listOf(
    dataModule,
    presentationModule,
    domainModule
)
