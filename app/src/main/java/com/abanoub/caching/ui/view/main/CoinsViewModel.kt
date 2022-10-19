package com.abanoub.caching.ui.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abanoub.caching.data.remote.api.CoinApi
import com.abanoub.caching.data.entity.Coin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    api: CoinApi
) : ViewModel() {
    private val coinsLiveData = MutableLiveData<List<Coin>>()
    val coins: LiveData<List<Coin>> = coinsLiveData

    init {
        viewModelScope.launch {
            val coins = api.getCoins()
            delay(2000)
            coinsLiveData.value = coins
        }
    }

}