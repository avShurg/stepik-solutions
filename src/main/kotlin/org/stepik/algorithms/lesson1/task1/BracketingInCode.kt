package org.stepik.algorithms.lesson1.task1

fun main() {
    println(readLine()?.let { isBalanced(it) })
}

fun isBalanced(inputString: String): String {
    if (inputString.isEmpty()) return "Success"
    val stack = arrayOfNulls<Char>(inputString.length)
    var indexStack = 0
    var lastIndexStack = 0
    var lastIndexOpenBracket = 0
    inputString.forEachIndexed { index, chr ->
        if (chr in arrayOf('[', '{', '(', ']', '}', ')')) {
            if (chr in arrayOf('[', '{', '(')) {
                stack[indexStack] = chr
                lastIndexOpenBracket = index
                lastIndexStack = indexStack
                indexStack++
            } else {
                if (stack[0] == null) {
                    return (index + 1).toString()
                }
                val last = stack[lastIndexStack]
                if (last == '[' && chr == ']'
                    || last == '{' && chr == '}'
                    || last == '(' && chr == ')'
                ) {
                    stack[lastIndexStack] = null
                    indexStack = lastIndexStack
                    lastIndexStack--
                    lastIndexOpenBracket--
                } else {
                    return (index + 1).toString()
                }
            }
        }
    }
    return if (stack[0] == null) {
        "Success"
    } else {
        (lastIndexOpenBracket+1).toString()
    }
}