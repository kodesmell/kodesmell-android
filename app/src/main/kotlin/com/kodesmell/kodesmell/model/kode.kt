package com.kodesmell.kodesmell.model

/**
 * Created by sangcomz on 12/08/2017.
 */
data class Kode(val id: String,
                val message: String?,
                val hash: String,
                val code: String?,
                val fileName: String,
                val lineNumber: Int,
                val project: Project)