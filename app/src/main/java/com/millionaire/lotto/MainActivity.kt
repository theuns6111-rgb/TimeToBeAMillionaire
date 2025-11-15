package com.millionaire.lotto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottoApp()
        }
    }
}

@Composable
fun LottoApp() {
    var numbers by remember { mutableStateOf(listOf<Int>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            numbers = LottoGenerator.generateNumbers()
        }) {
            Text(text = "Generate Lotto Numbers", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            for (num in numbers) {
                BasicText(
                    text = num.toString(),
                    modifier = Modifier
                        .background(Color(0xFFFFD700))
                        .padding(12.dp),
                    fontSize = 24.sp
                )
            }
        }
    }
}

object LottoGenerator {
  
    fun generateNumbers(): List<Int> {
        val numbers = mutableSetOf<Int>()
        while (numbers.size < 6) {
            numbers.add((1..40).random())
        }
        return numbers.toList().sorted()
    }
}

