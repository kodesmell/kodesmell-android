package com.kodesmell.kodesmell.adapter

import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kodesmell.kodesmell.R
import com.kodesmell.kodesmell.model.Kode

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
        val txtItemMessage = itemView.findViewById(R.id.txt_item_message) as AppCompatTextView
        fun setItem(kode: Kode) {
            txtItemMessage.text = kode.message
        }
    }
}