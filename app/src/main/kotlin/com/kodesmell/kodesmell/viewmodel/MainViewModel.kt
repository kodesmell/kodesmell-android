package com.kodesmell.kodesmell.viewmodel

import android.arch.lifecycle.ViewModel
import com.apollographql.apollo.rx2.Rx2Apollo
import com.kodesmell.kodesmell.KodesQuery
import com.kodesmell.kodesmell.api.ApiManager
import com.kodesmell.kodesmell.api.convert.KodeConvert
import com.kodesmell.kodesmell.model.Kodesmell
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by sangcomz on 12/08/2017.
 */
class MainViewModel : ViewModel() {
    val api = ApiManager().getClient()
    fun getKodesmells(): Observable<List<Kodesmell>> {
        val kodeQuery = KodesQuery.builder().build()
        val watcher = api.query(kodeQuery).watcher()
        return Rx2Apollo.from(watcher)
                .subscribeOn(Schedulers.newThread())
                .map {
                    KodeConvert(it.data())
                }
    }

}