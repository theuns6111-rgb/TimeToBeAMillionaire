package com.millionaire.lotto

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

object CsvImporter {
    fun importOldDraws(context: Context, fileName: String): List<List<Int>> {
        val draws = mutableListOf<List<Int>>()
        try {
            val inputStream = context.assets.open(fileName)
            val reader = BufferedReader(InputStreamReader(inputStream))
            reader.forEachLine { line ->
                val numbers = line.split(",").mapNotNull { it.toIntOrNull() }
                if (numbers.isNotEmpty()) draws.add(numbers)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return draws
    }
}
