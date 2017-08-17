package com.kodesmell.kodesmell.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.kodesmell.kodesmell.R
import com.kodesmell.kodesmell.model.Kodesmell
import io.github.kbiakov.codeview.adapters.Options
import io.github.kbiakov.codeview.highlight.ColorTheme
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setToolbar()
        setView()
    }

    private fun setToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setView() {
        val kodesmell = Gson()
                .fromJson(intent.extras.getString("kodesmell"),
                        Kodesmell::class.java)
        txt_detail_message.text = kodesmell.message


        kodesmell.code?.let {
            cv_detail_code.setOptions(Options.Default.get(this)
                    .withCode(it)
                    .withLanguage("java")
                    .withTheme(ColorTheme.MONOKAI))
        }
    }
}
