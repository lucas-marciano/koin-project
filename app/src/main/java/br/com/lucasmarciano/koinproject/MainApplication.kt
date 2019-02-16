package br.com.lucasmarciano.koinproject

import android.app.Application
import org.koin.android.ext.android.startKoin

/**
 * Main class application of the app.
 *
 * @project KoinProject
 * @create_at 14/02/19
 * @author lucasmarciano
 */
class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(applicationModule))
    }
}