package com.example.vk_test_task.data.network

import com.example.vk_test_task.data.dto.Response
import com.example.vk_test_task.data.repository.CurrencyNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrencyNetworkClientImpl(private val api: Api) : CurrencyNetworkClient {
    override suspend fun deRequest(currency: String): Response {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getCurrencyRates(currency)
                response.apply { resultCode = 200 }
            } catch (ex: Throwable) {
                Response().apply { resultCode = 400 }
            }
        }
    }
}