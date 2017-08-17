package com.kodesmell.kodesmell.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.kodesmell.kodesmell.R
import com.kodesmell.kodesmell.model.Kodesmell
import com.kodesmell.kodesmell.view.DetailActivity
import io.github.kbiakov.codeview.CodeView
import io.github.kbiakov.codeview.adapters.Options
import io.github.kbiakov.codeview.highlight.ColorTheme

/**
 * Created by sangcomz on 12/08/2017.
 */
class KodeListAdapter(val kodesmells: List<Kodesmell>) : RecyclerView.Adapter<KodeListAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.let {
            it.setItem(kodesmells[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_kodes, parent, false))
    }

    override fun getItemCount(): Int = kodesmells.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val context: Context = itemView.context

        val txtItemMessage: AppCompatTextView
                = itemView.findViewById<AppCompatTextView>(R.id.txt_item_message)

        val cvItemCode: CodeView
                = itemView.findViewById<CodeView>(R.id.cv_item_code)

        val imgItemFull: AppCompatImageView
                = itemView.findViewById<AppCompatImageView>(R.id.img_item_full)

        fun setItem(kode: Kodesmell) {
            txtItemMessage.text = kode.message

            kode.code?.let {
                cvItemCode.setOptions(Options.Default.get(context)
                        .withCode(getShortCode(it.lines(), kode.lineNumber))
                        .withLanguage("java")
                        .withTheme(ColorTheme.MONOKAI))
            }

            imgItemFull.setOnClickListener {
                val i: Intent = Intent(context, DetailActivity::class.java)
                i.putExtra("kodesmell", Gson().toJson(kode))
                context.startActivity(i)
            }
        }

        fun getShortCode(lines: List<String>, lineNumber: Int): String {
            var result: String = ""
            for (i in lineNumber - 4..lineNumber + 3) {
                result += lines[i] + "\n"
            }
            return result
        }
    }
}