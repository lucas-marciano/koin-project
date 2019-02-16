package br.com.lucasmarciano.koinproject

import br.com.lucasmarciano.koinproject.model.Currency

/**
 * [Description]
 *
 * @project KoinProject
 * @create_at 16/02/19
 * @author lucasmarciano
 */
object CurrencyFactory {
    fun makeCurrency(): Currency {
        return Currency(DataFactory.randomInt(), DataFactory.randomUuid(),
            DataFactory.randomUuid(), DataFactory.randomUuid())
    }

    fun makeCurrencyList(count: Int): List<Currency> {
        return (0..count).map { makeCurrency() }
    }
}