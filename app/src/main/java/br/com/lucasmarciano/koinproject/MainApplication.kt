package br.com.lucasmarciano.koinproject

import android.app.Application
import br.com.lucasmarciano.koinproject.utils.KoinLogger
import org.koin.android.ext.android.startKoin
import timber.log.Timber

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
        if(BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())

        startKoin(this, listOf(applicationModule), loadProperties = true, logger = KoinLogger())
    }
}