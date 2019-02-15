package br.com.lucasmarciano.koinproject

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.lucasmarciano.koinproject.presentation.CurrencyViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val currencyAdapter: CurrencyAdapter by inject()
    private val viewModel: CurrencyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        viewModel.observerCurrencies().observe(this, Observer {
            it?.let { currencies ->
                currencyAdapter.currencies = currencies
            }
        })

        val currenciesJson = resources.openRawResource(R.raw.currencies).bufferedReader().use {
            it.readText()
        }
        viewModel.retrieveCurrencies(currenciesJson)
    }

    private fun setupRecyclerView() {
        rv_currencies.layoutManager = LinearLayoutManager(this)
        rv_currencies.adapter = currencyAdapter
    }
}
