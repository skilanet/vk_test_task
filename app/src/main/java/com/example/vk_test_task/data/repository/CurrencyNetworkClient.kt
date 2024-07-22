package com.example.vk_test_task.data.repository

import com.example.vk_test_task.data.dto.Response

interface CurrencyNetworkClient {
    suspend fun deRequest(currency: String): Response
}