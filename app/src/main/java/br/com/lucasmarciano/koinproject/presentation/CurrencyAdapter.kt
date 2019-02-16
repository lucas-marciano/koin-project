package br.com.lucasmarciano.koinproject.presentation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucasmarciano.koinproject.R
import br.com.lucasmarciano.koinproject.model.Currency

/**
 * Adapter of the list of the Currencies.
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
        viewHolder.currencyView.setCurrency(currencies[position])
    }


    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val currencyView: CurrencyView = view.findViewById(R.id.view_currency)
    }
}