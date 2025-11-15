package com.millionaire.lotto

object LottoGenerator {
    fun generateNumbers(): List<Int> {
        val numbers = mutableSetOf<Int>()
        while (numbers.size < 6) {
            numbers.add((1..40).random())
        }
        return numbers.toList().sorted()
    }
}
