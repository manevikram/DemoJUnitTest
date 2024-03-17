package com.demo.unittest.utils

import java.lang.IllegalArgumentException

/**
 * Created by Vikram Mane on 3/16/24.
 */
class Utils {

    // Function to check if provided string is palindrome.
    fun isPalindrome(input : String) : Boolean {
        var startIndex = 0
        var endIndex = input.length - 1
        var result = true

        while (startIndex < endIndex){
            if (input[startIndex] != input[endIndex]) {
                result = false
                break
            }
            startIndex++
            endIndex--
        }
        return result
    }

    // Check password validity (Password length should be between 6 to 15 char)
    fun isPasswordValid(password : String) = when {
            password.isBlank() -> {"Password is required field"}
            password.length < 6 -> {"Password should be greater than 6"}
            password.length > 15 -> {"Password should be less than 15"}
            else -> "Valid Password"
        }

    // Function to reverse the string
    fun reversString(input : String?) : String {
        if(input == null){
            throw IllegalArgumentException("Input Required")
        }
        val chars = input.toCharArray()
        var start = 0
        var end = chars.size - 1

        while (start < end){
            val temp = chars[start]
            chars[start] = chars[end]
            chars[end] = temp
            start++
            end--
        }
        return chars.joinToString("")
    }
}