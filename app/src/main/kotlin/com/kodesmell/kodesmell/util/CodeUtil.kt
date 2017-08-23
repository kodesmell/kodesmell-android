package com.kodesmell.kodesmell.util

/**
 * Created by sangcomz on 23/08/2017.
 */

fun getShortCode(lines: List<String>, lineNumber: Int): String {
    var result: String = ""
    val index = getShortCodeRange(lines, lineNumber)
    for (i in index.first..index.second) {
        result += lines[i] + "\n"
    }
    return result
}

fun getShortCodeRange(lines: List<String>, lineNumber: Int): Pair<Int, Int> {
    if (lines.size < 8) {
        return Pair(0, lines.lastIndex)
    }
    var startIndex = lineNumber - 4
    var endIndex = lineNumber + 3
    while (!(startIndex >= 0 &&
            endIndex <= lines.lastIndex)) {
        if (startIndex < 0) {
            startIndex++
            endIndex++
        } else if (endIndex > lines.lastIndex) {
            startIndex--
            endIndex--
        }
    }
    return Pair(startIndex, endIndex)
}