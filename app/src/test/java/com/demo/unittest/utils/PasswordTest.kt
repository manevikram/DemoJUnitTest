package com.demo.unittest.utils

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by Vikram Mane on 3/16/24.
 */
class PasswordTest {

    private lateinit var sut : Utils

    @Before
    fun setUp(){
        sut = Utils()
    }
    @Test
    fun test_isPasswordValid_BlankInput_Expected_PasswordRequired(){
        val result = sut.isPasswordValid( " ")
        assertEquals("Password is required field", result)
    }

    @Test
    fun test_isPasswordValid_LessThan_6_Expected_InvalidMessage(){
        val result = sut.isPasswordValid( "ab")
        assertEquals("Password should be greater than 6", result)
    }

    @Test
    fun test_isPasswordValid_MoreThan_15Char_Expected_InvalidMessage(){
        val result = sut.isPasswordValid( "Password12345678")
        assertEquals("Password should be less than 15", result)
    }

    @Test
    fun test_isPasswordValid_ValidInput_Expected_ValidMessage(){
        val result = sut.isPasswordValid( "Password123")
        assertEquals("Valid Password", result)
    }
}