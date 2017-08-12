package com.kodesmell.kodesmell.api.convert

import com.kodesmell.kodesmell.KodesQuery
import com.kodesmell.kodesmell.model.Kode
import com.kodesmell.kodesmell.model.Project

/**
 * Created by sangcomz on 12/08/2017.
 */
fun KodeConvert(data: KodesQuery.Data?): ArrayList<Kode> {
    val result = arrayListOf<Kode>()
    data?.kodes()?.let {
        it.mapTo(result, {
            Kode(it.id(), it.message(), it.hash(), it.code(), it.fileName(), it.lineNumber(), Project(it.project().id(), it.project().__typename()))
        })
    }
    return result
}