package com.example.vk_test_task.di

import com.example.vk_test_task.presentation.CurrencyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<CurrencyViewModel> {
        CurrencyViewModel(get())
    }
}