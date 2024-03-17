package com.demo.unittest.utils

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.lang.IllegalArgumentException

/**
 * Created by Vikram Mane on 3/16/24.
 */
class StringTest {

    lateinit var sut : Utils

    @Before
    fun setUp(){
        sut = Utils()
    }
    @Test(expected = IllegalArgumentException::class)
    fun test_reversString_Null_Expected_Exception(){
        sut.reversString(null)
    }

    @Test
    fun test_reversString_EmptyString_Expected_Empty(){
        val result = sut.reversString("")
        assertEquals("", result)
    }

    @Test
    fun test_reversString_SingleChar_Expected_SingleChar(){
        val result = sut.reversString("a")
        assertEquals("a", result)
    }

    @Test
    fun test_reversString_ValidString_Expected_ValidReverse(){
        val result = sut.reversString("vikram")
        assertEquals("markiv", result)
    }
}