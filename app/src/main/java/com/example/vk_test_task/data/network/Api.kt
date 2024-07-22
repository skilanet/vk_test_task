package com.example.vk_test_task.data.network

import com.example.vk_test_task.data.dto.CurrencyDto
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("{currency}")
    suspend fun getCurrencyRates(@Path("currency") currency: String): CurrencyDto
}