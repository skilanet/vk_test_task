package com.example.vk_test_task.domain.repository

import com.example.vk_test_task.domain.models.Resource
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {
    fun getCurrencyRates(currency: String): Flow<Resource>
}