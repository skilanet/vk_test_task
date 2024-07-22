package com.example.vk_test_task.data.impl

import com.example.vk_test_task.data.dto.CurrencyDto
import com.example.vk_test_task.data.mapper.CurrencyMapper
import com.example.vk_test_task.data.repository.CurrencyNetworkClient
import com.example.vk_test_task.domain.models.Resource
import com.example.vk_test_task.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CurrencyRepositoryImpl(private val client: CurrencyNetworkClient) : CurrencyRepository {
    override fun getCurrencyRates(currency: String): Flow<Resource> = flow {
        val response = client.deRequest(currency)
        when (response.resultCode) {
            200 -> with(response as CurrencyDto) {
                val data = CurrencyMapper.fromDtoToModel(this)
                emit(Resource.Success(data, resultCode))
            }

            else -> emit(Resource.Error(response.resultCode))
        }
    }
}