package com.abanoub.caching.data.local

import androidx.room.*
import com.abanoub.caching.data.entity.Coin
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinDao {

    @Query("SELECT * FROM coins")
    fun getAllCoins(): Flow<List<Coin>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoins(coins: List<Coin>)

    @Query("DELETE FROM coins")
    suspend fun deleteAllCoins()

}