package com.example.vk_test_task.domain.impl

import com.example.vk_test_task.domain.models.CurrencyRates
import com.example.vk_test_task.domain.models.Resource
import com.example.vk_test_task.domain.repository.CurrencyInteractor
import com.example.vk_test_task.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

class CurrencyInteractorImpl(private val repository: CurrencyRepository) : CurrencyInteractor {
    override fun getCurrencies(currency: String): Flow<CurrencyRates?> {
        return repository.getCurrencyRates(currency).mapNotNull { result ->
            when (result) {
                is Resource.Success -> result.data
                is Resource.Error -> null
            }
        }
    }
}