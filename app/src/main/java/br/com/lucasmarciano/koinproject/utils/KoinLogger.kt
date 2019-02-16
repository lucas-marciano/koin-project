package br.com.lucasmarciano.koinproject.utils

import org.koin.log.Logger
import timber.log.Timber


/**
 * [Description]
 *
 * @project KoinProject
 * @create_at 16/02/19
 * @author lucasmarciano
 */
class KoinLogger: Logger {

    override fun debug(msg: String) {
        Timber.d(msg)
    }

    override fun err(msg: String) {
        Timber.e(msg)
    }

    override fun info(msg: String) {
        Timber.i(msg)
    }
}