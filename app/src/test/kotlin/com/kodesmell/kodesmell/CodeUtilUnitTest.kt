package com.kodesmell.kodesmell

import com.kodesmell.kodesmell.util.getShortCodeRange
import org.junit.Assert
import org.junit.Test

/**
 * Created by sangcomz on 23/08/2017.
 */
class CodeUtilUnitTest {

    @Test
    @Throws(Exception::class)
    fun getCodeRangeShort() {
        val list = arrayListOf<String>()
        (0..4).forEach {
            list.add("")
        }

        Assert.assertEquals(Pair(0, 4), getShortCodeRange(list, 0))
        Assert.assertEquals(Pair(0, 4), getShortCodeRange(list, 1))
        Assert.assertEquals(Pair(0, 4), getShortCodeRange(list, 2))
        Assert.assertEquals(Pair(0, 4), getShortCodeRange(list, 3))
        Assert.assertEquals(Pair(0, 4), getShortCodeRange(list, 4))
    }

    @Test
    @Throws(Exception::class)
    fun getCodeRangeNormal() {
        val list = arrayListOf<String>()
        (0..9).forEach {
            list.add("")
        }
        Assert.assertEquals(Pair(0, 7), getShortCodeRange(list, 0))
        Assert.assertEquals(Pair(0, 7), getShortCodeRange(list, 2))
        Assert.assertEquals(Pair(2, 9), getShortCodeRange(list, 8))
        Assert.assertEquals(Pair(2, 9), getShortCodeRange(list, 10))
    }
}