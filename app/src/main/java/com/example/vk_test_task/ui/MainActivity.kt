package com.example.vk_test_task.ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.vk_test_task.R
import com.example.vk_test_task.databinding.ActivityMainBinding
import com.example.vk_test_task.domain.models.CurrencyRates
import com.example.vk_test_task.presentation.CurrencyViewModel
import com.example.vk_test_task.ui.models.CurrencyState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<CurrencyViewModel>()
    private val currencies = listOf("Рубль", "Доллар", "Евро", "Юань", "Фунт Стерлингов")
    private var _rates: CurrencyState = CurrencyState.Error
    private var koeff: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.observeCurrencyState().observe(this) {
            renderState(it)
        }

        val adapter = CustomSpinnerAdapter(this, android.R.layout.simple_spinner_item, currencies)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerFrom.adapter = adapter
        binding.spinnerTo.adapter = adapter


        binding.spinnerFrom.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.search(renderPosition(position))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }
        binding.spinnerTo.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                renderState(_rates)
                renderPosition(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }

        binding.btnConvert.setOnClickListener {
            binding.tvBigTo.text = (binding.etFrom.text.toString().toInt() * koeff).toString()
        }
    }

    private fun renderState(state: CurrencyState) {
        when (state) {
            is CurrencyState.Content -> {
                _rates = state
                showContent(state.data)
            }

            is CurrencyState.Error -> binding.btnConvert.isActivated = false
        }
    }

    private fun showContent(rates: CurrencyRates) {
        val key = renderSelectedItem(binding.spinnerTo)
        koeff = rates.currencyRates[key]!!
        binding.tvCurrencyRatio.text = getString(
            R.string.currency_ratio,
            rates.baseCode,
            koeff, key
        )
    }

    private fun renderSelectedItem(spinner: Spinner): String {
        return when (spinner.selectedItem) {
            "Рубль" -> "RUB"
            "Доллар" -> "USD"
            "Евро" -> "EUR"
            "Юань" -> "CNY"
            "Фунт Стерлингов" -> "GBP"
            else -> {
                ""
            }
        }
    }

    private fun renderPosition(position: Int): String {
        return when (position) {
            0 -> "RUB"
            1 -> "USD"
            2 -> "EUR"
            3 -> "CNY"
            4 -> "GBP"
            else -> ""
        }
    }
}