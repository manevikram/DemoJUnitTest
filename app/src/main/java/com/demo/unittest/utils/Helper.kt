package com.demo.unittest.utils

class Helper {

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
}