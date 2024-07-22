package com.example.vk_test_task.domain.models

sealed class Resource(val data: CurrencyRates? = null, val code: Int) {
    class Success(data: CurrencyRates, code: Int): Resource(data, code)
    class Error(code: Int): Resource(code = code)
}