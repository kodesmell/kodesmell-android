package com.kodesmell.kodesmell.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.appKodein
import com.kodesmell.kodesmell.R
import com.kodesmell.kodesmell.adapter.KodeListAdapter
import com.kodesmell.kodesmell.model.Kode
import com.kodesmell.kodesmell.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), KodeinInjected {
    override val injector: KodeinInjector = KodeinInjector()

//    val apiClient: ApolloClient by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        inject(appKodein())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getKode().subscribe { setView(it) }
    }

    private fun setView(kodes: List<Kode>) {
        rv_main_list.layoutManager = LinearLayoutManager(this)
        rv_main_list.adapter = KodeListAdapter(kodes)
    }

}
