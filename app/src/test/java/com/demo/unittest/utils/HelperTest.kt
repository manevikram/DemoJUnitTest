package com.demo.unittest.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    private lateinit var helper : Helper

    @Before
    fun setUp(){
        helper = Helper()
    }

    @After
    fun tearDown(){
        //println("After every test case")
    }

    @Test
    fun test_isPalindrome_Input_hello_Expected_false() {
        val result = helper.isPalindrome("hello")
        assertEquals(false, result)
    }

    @Test
    fun test_isPalindrome_Input_level_Expected_true() {
        val result = helper.isPalindrome("level")
        assertEquals(true, result)
    }
}