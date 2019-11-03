package org.stepik.algorithms.lesson1.task1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BracketingInCodeKtTest {

    @Test
    fun isBalanced() {
        assertEquals("Success", isBalanced(""))
        assertEquals("3", isBalanced("[[["))
        assertEquals("5", isBalanced("[]{}}"))
        assertEquals("5", isBalanced("[]{}{"))
        assertEquals("Success", isBalanced("foo(bar);"))
        assertEquals("10", isBalanced("foo(bar[i);"))
    }
}