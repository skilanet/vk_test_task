package com.example.vk_test_task.data.dto

import com.google.gson.annotations.SerializedName

data class ConversionRates(
    @SerializedName("CNY")
    val cny: Double,
    @SerializedName("EUR")
    val eur: Double,
    @SerializedName("GBP")
    val gpb: Double,
    @SerializedName("RUB")
    val rub: Double,
    @SerializedName("USD")
    val usd: Double,
)