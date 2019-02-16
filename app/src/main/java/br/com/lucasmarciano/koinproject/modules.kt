package br.com.lucasmarciano.koinproject

import br.com.lucasmarciano.koinproject.data.DataRepository
import br.com.lucasmarciano.koinproject.data.DataRepositoryFactory
import br.com.lucasmarciano.koinproject.data.LocalDataRepository
import br.com.lucasmarciano.koinproject.data.RemoteDataRepository
import br.com.lucasmarciano.koinproject.presentation.CurrencyAdapter
import br.com.lucasmarciano.koinproject.presentation.CurrencyViewModel
import br.com.lucasmarciano.koinproject.utils.UrlHelper
import com.google.gson.Gson
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * Main module of the Koin
 *
 * @project KoinProject
 * @create_at 14/02/19
 * @author lucasmarciano
 */

val applicationModule = module {
    single { Gson() }
    single { UrlHelper() }

    scope("browse") { CurrencyAdapter() }
    factory<DataRepository>("local") { LocalDataRepository(get()) }
    factory<DataRepository>("remote") { RemoteDataRepository() }
    factory { DataRepositoryFactory(get("local"), get("remote")) }

    viewModel { CurrencyViewModel(get()) }

}