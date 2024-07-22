package com.example.vk_test_task.di

import com.example.vk_test_task.data.impl.CurrencyRepositoryImpl
import com.example.vk_test_task.data.network.Api
import com.example.vk_test_task.data.network.CurrencyNetworkClientImpl
import com.example.vk_test_task.data.repository.CurrencyNetworkClient
import com.example.vk_test_task.domain.repository.CurrencyRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single<Api> {
        Retrofit.Builder().baseUrl("https://v6.exchangerate-api.com/v6/0ae8ed401deae2852cb15021/latest/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(Api::class.java)
    }

    single<CurrencyRepository> {
        CurrencyRepositoryImpl(get())
    }

    single<CurrencyNetworkClient> {
        CurrencyNetworkClientImpl(get())
    }
}