package com.example.vk_test_task.data.mapper

import com.example.vk_test_task.data.dto.CurrencyDto
import com.example.vk_test_task.domain.models.CurrencyRates

object CurrencyMapper {
    fun fromDtoToModel(dto: CurrencyDto): CurrencyRates = CurrencyRates(
        baseCode = dto.baseCode,
        currencyRates = with(dto.conversionRates) {
            mapOf(
                "RUB" to rub,
                "USD" to usd,
                "EUR" to eur,
                "CNY" to cny,
                "GBP" to gpb
            )
        }
    )
}