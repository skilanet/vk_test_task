package com.example.vk_test_task.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vk_test_task.domain.repository.CurrencyInteractor
import com.example.vk_test_task.ui.models.CurrencyState
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CurrencyViewModel(
    private val currencyInteractor: CurrencyInteractor
) : ViewModel() {

    private val currencyState = MutableLiveData<CurrencyState>()
    fun observeCurrencyState(): LiveData<CurrencyState> = currencyState
    private var latestCurrencyCode = ""

    private var searchJob: Job? = null

    fun search(currencyCode: String) {
        if (latestCurrencyCode == currencyCode) return
        latestCurrencyCode = currencyCode
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            sendRequest(currencyCode)
        }
    }

    private fun sendRequest(currencyCode: String) {
        viewModelScope.launch {
            currencyInteractor.getCurrencies(currencyCode).collect {
                if (it == null) currencyState.value = CurrencyState.Error
                else currencyState.value = CurrencyState.Content(it)
            }
        }
    }
}