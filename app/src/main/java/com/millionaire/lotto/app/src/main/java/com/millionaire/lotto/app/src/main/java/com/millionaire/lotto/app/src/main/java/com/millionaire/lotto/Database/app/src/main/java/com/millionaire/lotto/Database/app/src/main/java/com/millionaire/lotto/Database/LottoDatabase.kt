package com.millionaire.lotto.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LottoDraw::class], version = 1)
abstract class LottoDatabase : RoomDatabase() {
    abstract fun lottoDao(): LottoDao

    companion object {
        @Volatile
        private var INSTANCE: LottoDatabase? = null

        fun getDatabase(context: Context): LottoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LottoDatabase::class.java,
                    "lotto_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
