package com.demo.unittest

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import java.io.FileNotFoundException

/**
 * Created by Vikram Mane on 3/16/24.
 */
class QuoteManagerTest {

    private lateinit var quoteManager : QuoteManager
    private lateinit var context: Context

    @Before
    fun setUp(){
        quoteManager = QuoteManager()
        context = ApplicationProvider.getApplicationContext()
    }

    @Test(expected = FileNotFoundException::class)
    fun test_getQuoteListFromAsset_Wrong_JSON_Expected_Exception() {
        quoteManager.getQuoteListFromAsset(context = context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun test_getQuoteListFromAsset_Invalid_JSON_Expected_Exception() {
        quoteManager.getQuoteListFromAsset(context = context, "malformed.json")
    }

    @Test
    fun test_getQuoteListFromAsset_Valid_JSON_Expected_ListCount() {
        quoteManager.getQuoteListFromAsset(context = context, "quotes.json")
        assertEquals(3, quoteManager.quoteList.size)
    }

    @Test
    fun test_getCurrentQuote_Expected_CorrectQuote(){
        quoteManager.getQuotes(arrayOf(
            Quote("Test Quote 1","1"),
            Quote("Test Quote 2","2"),
            Quote("Test Quote 3","3")
        ))
        val quote = quoteManager.getCurrentQuote()
        assertEquals("1", quote.author)
    }

    @Test
    fun test_getNextQuote_Expected_CorrectQuote(){
        quoteManager.getQuotes(arrayOf(
            Quote("Test Quote 1","1"),
            Quote("Test Quote 2","2"),
            Quote("Test Quote 3","3")
        ))
        val quote = quoteManager.getNextQuote()
        assertEquals("2", quote.author)
    }

    @Test
    fun test_getPreviousQuote_Expected_CorrectQuote(){
        quoteManager.getQuotes(arrayOf(
            Quote("Test Quote 1","1"),
            Quote("Test Quote 2","2"),
            Quote("Test Quote 3","3")
        ))
        val quote = quoteManager.getPreviousQuote()
        assertEquals("1", quote.author)
    }
}