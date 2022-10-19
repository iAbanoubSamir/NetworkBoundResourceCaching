package com.abanoub.caching.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abanoub.caching.data.entity.Coin

@Database(entities = [Coin::class], version = 1)
abstract class CoinsDatabase : RoomDatabase() {

    abstract fun coinDao(): CoinDao

}