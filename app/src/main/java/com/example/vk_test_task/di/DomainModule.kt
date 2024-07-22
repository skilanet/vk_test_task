package com.example.vk_test_task.di

import com.example.vk_test_task.domain.impl.CurrencyInteractorImpl
import com.example.vk_test_task.domain.repository.CurrencyInteractor
import org.koin.dsl.module

val domainModule = module {
    single<CurrencyInteractor> {
        CurrencyInteractorImpl(get())
    }
}