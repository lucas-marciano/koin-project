package br.com.lucasmarciano.koinproject

import br.com.lucasmarciano.koinproject.data.DataRepository
import br.com.lucasmarciano.koinproject.data.DataRepositoryImpl
import com.google.gson.Gson
import org.koin.dsl.module.module

/**
 * [Description]
 *
 * @project KoinProject
 * @create_at 14/02/19
 * @author lucasmarciano
 */

val applicationModule = module {
    single { Gson() }
    factory { CurrencyAdapter() }
    factory { DataRepositoryImpl(get()) as DataRepository}
}