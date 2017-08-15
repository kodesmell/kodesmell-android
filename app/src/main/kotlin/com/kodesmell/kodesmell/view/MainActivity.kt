package com.kodesmell.kodesmell.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.kodesmell.kodesmell.R
import com.kodesmell.kodesmell.adapter.KodeListAdapter
import com.kodesmell.kodesmell.model.Kodesmell
import com.kodesmell.kodesmell.viewmodel.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ;) viewmodel 정리 (#fe006d5)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel
                .getKode()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { setView(it) }
    }

    private fun setView(kodes: List<Kodesmell>) {
        rv_main_list.layoutManager = LinearLayoutManager(this)
        rv_main_list.adapter = KodeListAdapter(kodes)
    }

}
