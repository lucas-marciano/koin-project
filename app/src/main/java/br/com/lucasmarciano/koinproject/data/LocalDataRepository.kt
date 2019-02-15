package br.com.lucasmarciano.koinproject.data

import br.com.lucasmarciano.koinproject.model.Currency
import com.google.gson.Gson

/**
 * [Description]
 *
 * @project KoinProject
 * @create_at 14/02/19
 * @author lucasmarciano
 */
open class LocalDataRepository(private val gson: Gson) : DataRepository{

    override fun getCurrencies(jsonString: String): List<Currency> {
        return gson.fromJson(jsonString, Array<Currency>::class.java).toList()
    }

}