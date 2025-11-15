package com.millionaire.lotto.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lotto_draws")
data class LottoDraw(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val numbers: String // store as comma-separated string
)
