package com.kodesmell.kodesmell.api.convert

import com.kodesmell.kodesmell.KodesQuery
import com.kodesmell.kodesmell.model.Kodesmell
import com.kodesmell.kodesmell.model.Project

/**
 * Created by sangcomz on 12/08/2017.
 */
fun KodeConvert(data: KodesQuery.Data?): ArrayList<Kodesmell> {
    val result = arrayListOf<Kodesmell>()
    data?.kodes()?.let {
        it.mapTo(result, {
            Kodesmell(it.id(), it.message(), it.hash(), it.code(), it.fileName(), it.lineNumber(), null)
        })
    }
    return result
}