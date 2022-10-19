package com.abanoub.caching.di

import android.app.Application
import androidx.room.Room
import com.abanoub.caching.data.local.CoinDao
import com.abanoub.caching.data.local.CoinsDatabase
import com.abanoub.caching.data.remote.api.CoinApi
import com.abanoub.caching.data.remote.api.CoinApi.Companion.BASE_URL
import com.abanoub.caching.utils.Constants.COINS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideCoinApi(retrofit: Retrofit): CoinApi =
        retrofit.create(CoinApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): CoinsDatabase =
        Room.databaseBuilder(app, CoinsDatabase::class.java, COINS_DATABASE_NAME)
            .build()

}