package br.com.lucasmarciano.koinproject.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import br.com.lucasmarciano.koinproject.R
import br.com.lucasmarciano.koinproject.utils.UrlHelper
import br.com.lucasmarciano.koinproject.model.Currency
import kotlinx.android.synthetic.main.view_currency.view.*
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

/**
 * Custom view to show the currencies, item per item
 *
 * @project KoinProject
 * @create_at 16/02/19
 * @author lucasmarciano
 */
class CurrencyView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), KoinComponent {

    private val urlHelper: UrlHelper by inject()

    init {
        View.inflate(context, R.layout.view_currency, this)
    }

    fun setCurrency(currency: Currency) {
        tv_name.text = currency.name
        tv_symbol.text = currency.symbol

        setOnClickListener {
            urlHelper.lauchUrlCurrency(context, currency.slug)
        }
    }
}