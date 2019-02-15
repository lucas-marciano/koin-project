package br.com.lucasmarciano.koinproject

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.lucasmarciano.koinproject.model.Currency

/**
 * [Description]
 *
 * @project KoinProject
 * @create_at 14/02/19
 * @author lucasmarciano
 */
class CurrencyAdapter: RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    var currencies: List<Currency> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = currencies.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindView(currencies[position])
    }


    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val nameCurrency = view.findViewById<TextView>(R.id.tv_name)
        private val symbolCurrency = view.findViewById<TextView>(R.id.tv_symbol)

        fun bindView(currency: Currency) {
            nameCurrency.text = currency.name
            symbolCurrency.text = currency.symbol
        }
    }
}