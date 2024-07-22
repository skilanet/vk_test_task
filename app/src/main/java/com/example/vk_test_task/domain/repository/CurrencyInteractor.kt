package com.example.vk_test_task.domain.repository

import com.example.vk_test_task.domain.models.CurrencyRates
import kotlinx.coroutines.flow.Flow

interface CurrencyInteractor {
    fun getCurrencies(currency: String): Flow<CurrencyRates?>
}