package com.example.vk_test_task.data.dto

import com.google.gson.annotations.SerializedName

data class CurrencyDto(
    @SerializedName("conversion_rates")
    val conversionRates: ConversionRates,
    val result: String,
    @SerializedName("base_code")
    val baseCode: String
): Response()