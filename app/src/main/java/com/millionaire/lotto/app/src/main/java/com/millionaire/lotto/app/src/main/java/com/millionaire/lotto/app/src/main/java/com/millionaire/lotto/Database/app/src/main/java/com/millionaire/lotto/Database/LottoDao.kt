package com.millionaire.lotto.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LottoDao {
    @Insert
    suspend fun insert(draw: LottoDraw)

    @Query("SELECT * FROM lotto_draws")
    suspend fun getAll(): List<LottoDraw>
}
