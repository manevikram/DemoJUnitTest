package com.demo.unittest.utils

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParametrisedHelperTest(private val input : String, private val expectedValue: Boolean) {

    private lateinit var helper : Helper

    @Before
    fun setUp(){
        helper = Helper()
    }

    @Test
    fun test_isPalindrome(){
        val result = helper.isPalindrome(input = input)
        assertEquals(expectedValue, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is palindrome {1}")
        fun data() : List<Array<Any>>{
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true)
            )
        }
    }

}