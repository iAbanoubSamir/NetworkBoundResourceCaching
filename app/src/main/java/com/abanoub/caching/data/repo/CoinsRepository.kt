package com.abanoub.caching.data.repo

import androidx.room.withTransaction
import com.abanoub.caching.data.local.CoinsDatabase
import com.abanoub.caching.data.remote.api.CoinApi
import com.abanoub.caching.utils.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class CoinsRepository @Inject constructor(
    private val api: CoinApi,
    private val db: CoinsDatabase
) {
    private val coinDao = db.coinDao()

    fun getCoins() = networkBoundResource(
        query = {
            coinDao.getAllCoins()
        },
        fetch = {
            delay(2000)
            api.getCoins()
        },
        saveFetchResult = { coins ->
            db.withTransaction {
                coinDao.deleteAllCoins()
                coinDao.insertCoins(coins)
            }
        }
    )
}