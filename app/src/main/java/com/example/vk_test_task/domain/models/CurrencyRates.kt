package com.example.vk_test_task.domain.models

data class CurrencyRates(
    val currencyRates: Map<String, Double>,
    val baseCode: String
)