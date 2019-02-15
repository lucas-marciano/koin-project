package br.com.lucasmarciano.koinproject.data

import br.com.lucasmarciano.koinproject.model.Currency

/**
 * [Description]
 *
 * @project KoinProject
 * @create_at 15/02/19
 * @author lucasmarciano
 */
interface DataRepository {

    fun getCurrencies(jsonString: String): List<Currency>
}