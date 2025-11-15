package com.millionaire.lotto

import kotlin.random.Random

object StatsAnalyzer {
    // Simple frequency-based prediction using old draws
    fun predictNextNumbers(oldDraws: List<List<Int>>): List<Int> {
        val frequency = mutableMapOf<Int, Int>()
        for (draw in oldDraws) {
            for (num in draw) {
                frequency[num] = frequency.getOrDefault(num, 0) + 1
            }
        }
        return frequency.entries
            .sortedByDescending { it.value }
            .take(6)
            .map { it.key }
    }
}
