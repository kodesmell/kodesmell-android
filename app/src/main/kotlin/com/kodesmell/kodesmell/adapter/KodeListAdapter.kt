package com.kodesmell.kodesmell.adapter

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kodesmell.kodesmell.R
import com.kodesmell.kodesmell.model.Kode
import io.github.kbiakov.codeview.CodeView
import io.github.kbiakov.codeview.adapters.Options
import io.github.kbiakov.codeview.highlight.ColorTheme

/**
 * Created by sangcomz on 12/08/2017.
 */
class KodeListAdapter(val kodes: List<Kode>) : RecyclerView.Adapter<KodeListAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.let {
            it.setItem(kodes[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_kodes, parent, false))
    }

    override fun getItemCount(): Int = kodes.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val context: Context = itemView.context
        val txtItemMessage = itemView.findViewById(R.id.txt_item_message) as AppCompatTextView
        val cvItemCode = itemView.findViewById(R.id.cv_item_code) as CodeView
        fun setItem(kode: Kode) {
            txtItemMessage.text = kode.message

            kode.code?.let {

                cvItemCode.setOptions(Options.Default.get(context)
                        .withCode(getShortCode(it.lines(), kode.lineNumber))
                        .withShadows()
                        .withTheme(ColorTheme.MONOKAI))
            }

        }

        fun getShortCode(lines: List<String>, lineNumber: Int): String {
            var result: String = ""
            for (i in lineNumber - 4..lineNumber + 3) {
                result += lines[i] +"\n"
            }
            return result
        }
    }
}