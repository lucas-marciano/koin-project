package br.com.lucasmarciano.koinproject.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.lucasmarciano.koinproject.data.DataRepositoryFactory
import br.com.lucasmarciano.koinproject.model.Currency

/**
 * View model of the MainActivity
 *
 * @project KoinProject
 * @create_at 15/02/19
 * @author lucasmarciano
 */
class CurrencyViewModel(private val dataRepositoryFactory: DataRepositoryFactory) : ViewModel() {

    private val currencyLiveData = MutableLiveData<List<Currency>>()

    fun observerCurrencies() = currencyLiveData

    fun retrieveCurrencies(json: String){
        val data = dataRepositoryFactory.retrieveLocalSource().getCurrencies(json)
        currencyLiveData.postValue(data)
    }
}