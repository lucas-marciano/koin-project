package br.com.lucasmarciano.koinproject

import br.com.lucasmarciano.koinproject.data.DataRepository
import br.com.lucasmarciano.koinproject.data.DataRepositoryFactory
import br.com.lucasmarciano.koinproject.data.LocalDataRepository
import br.com.lucasmarciano.koinproject.data.RemoteDataRepository
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

    factory<DataRepository>("local") { LocalDataRepository(get()) }
    factory<DataRepository>("remote") { RemoteDataRepository() }

    factory { DataRepositoryFactory(get("local"), get("remote")) }
}