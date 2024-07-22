package com.example.vk_test_task.ui.models

import com.example.vk_test_task.domain.models.CurrencyRates

sealed interface CurrencyState {
    data class Content(val data: CurrencyRates): CurrencyState
    data object Error: CurrencyState
}