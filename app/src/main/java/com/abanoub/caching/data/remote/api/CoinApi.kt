package com.abanoub.caching.data.remote.api

import com.abanoub.caching.data.remote.model.Coin
import retrofit2.http.GET

interface CoinApi {
    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("crypto_coin/random_crypto_coin?size=25")
    suspend fun getCoins(): List<Coin>
}