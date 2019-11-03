package org.stepik.algorithms.lesson1.task2

fun main() {
    var length = readLine()!!.toInt()
    val listChildren = mutableListOf<MutableList<Int>>()
    while (length > 0) {
        listChildren.add(mutableListOf())
        length--
    }
    var topTree = 0
    readLine()!!.split(" ").forEachIndexed { index, str ->
        if (str == "-1") {
            topTree = index
            return@forEachIndexed
        }
        listChildren[str.toInt()]!!.add(index)
    }
    fun heightTree(top: MutableList<Int>): Int {
        var height = 1

        for (element in top) {
            val h = 1+heightTree(listChildren[element])
            if (height < h) {
                height = h
            }
        }
        return height
    }
    println(heightTree(listChildren[topTree]))
}