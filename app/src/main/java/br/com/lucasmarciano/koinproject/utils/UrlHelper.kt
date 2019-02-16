package br.com.lucasmarciano.koinproject.utils

import android.content.Context
import android.net.Uri
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import br.com.lucasmarciano.koinproject.R

/**
 * Class to build and call the page url in the application
 *
 * @project KoinProject
 * @create_at 16/02/19
 * @author lucasmarciano
 */
class UrlHelper(private val baseUrl: String) {

    fun lauchUrlCurrency(context: Context, slug: String) {
        launchUrl(context, Uri.parse("$baseUrl$slug"))
    }

    private fun launchUrl(context: Context, uri: Uri) {
        val customTabsIntent = CustomTabsIntent.Builder()
            .addDefaultShareMenuItem()
            .setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary))
            .setShowTitle(true)
            .build()

        customTabsIntent.launchUrl(context, uri)
    }
}