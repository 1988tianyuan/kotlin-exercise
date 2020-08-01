package com.tianyuan.kotlindemo1

import com.tianyuan.kotlindemo1.Greeter.Companion.arrayCheck
import com.tianyuan.kotlindemo1.pa1.Util

fun main() {
    println("hello world")
    Greeter("liugeng").greet()
    val util = Util()
    println(util.sum(1, 2))
    println(util.vars(1,2,3,4,5))
    val sumFunc: (Int, Int) -> Int = {
        x,y -> x + y
    }
    println(sumFunc(5,6))
    var newV: Long = 0
    if (newV != 5L) {
        newV = 5
    }
    println(newV)
    println("这是一个Long变量:$newV")
    println("现在是:${Greeter("叶小舟").greet()}")

    println("${arrayCheck(arrayOf("2", "3"))}")

    var s: String? = null       // 可为null
    val i = s?.toInt()          // 若s为null，则toInt()返回null
    println(i)
    val i2 = s?.toInt() ?: -1   // 若s为null则返回-1
    println(i2)
    //val i3 = s!!.toInt()        // 若s为null则抛出空指针错误

    println("i2的长度是:${Greeter.getStringLength(i2)}")
    val liugeng = "liugeng"
    println("liugeng的长度是:${Greeter.getStringLength(liugeng)}")

    ArrayRangeTest.range()
    ArrayRangeTest.arrayFuncs()

    StringTest.test()
}

class Greeter(private val name: String) {
    fun greet(): String {
        val s = "hello $name"
        println(s)
        return s
    }

    companion object {
        fun arrayCheck(array: Array<String>): Int {
            val x = parseInt(array[0])
            val y = parseInt(array[1])
            return x*y
        }
        private fun parseInt(s: String): Int {
            return s.toInt()
        }
        fun getStringLength(obj: Any): Int? {
            if (obj is String) {
                return obj.length       // 自动转换为String
            }
            if (obj !is String) {
                return 0
            }
            return null
        }
    }
}

object ArrayRangeTest {
    fun range() {
        for (i in 1..10) {
            print("$i,")        // 1,2,3,4,5,6,7,8,9,10
        }
        println()
        for (i in 1..10 step 2) {
            print("$i,")        // 1,3,5,7,9
        }
        println()
        for (i in 10 downTo 1 step 2) {
            print("$i,")        // 10,8,6,4,2
        }
        println()
        for (i in 1 until 10) {
            print("$i,")        // 1,2,3,4,5,6,7,8,9
        }
        println()
    }

    fun arrayFuncs() {
        val array1 = arrayOf(1,2,3,4,5)
        val array2 = Array(5) { i -> i * 2 }
        array2.forEach { e -> print("$e,") }        // 0,2,4,6,8
        println()
    }
}

object StringTest {
    fun test() {
        val text = "liugeng"
        text.forEach { s -> print("$s,") }
        println()
        val text2 = """
            这是第一行
            这是第二行
        """.trimIndent()    // 删除多余的前后空格和换行
        println(text2)
    }
}