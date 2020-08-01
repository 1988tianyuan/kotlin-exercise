package com.tianyuan.kotlindemo1.pa1

class Util {

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun vars(vararg v:Int): Int {
        var sum = 0
        for (vt in v) {
            sum += vt
        }
        return sum
    }
}