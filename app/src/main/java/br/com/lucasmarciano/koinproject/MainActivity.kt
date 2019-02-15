package br.com.lucasmarciano.koinproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.lucasmarciano.koinproject.data.DataRepository
import br.com.lucasmarciano.koinproject.data.DataRepositoryFactory
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val currencyAdapter: CurrencyAdapter by inject()
    private val repository: DataRepository by inject("local")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        val currencyJson = resources.openRawResource(R.raw.currencies)
            .bufferedReader().use { it.readText() }
        val itens = repository.getCurrencies(currencyJson)
        currencyAdapter.currencies = itens
    }

    private fun setupRecyclerView() {
        rv_currencies.layoutManager = LinearLayoutManager(this)
        rv_currencies.adapter = currencyAdapter
    }
}
