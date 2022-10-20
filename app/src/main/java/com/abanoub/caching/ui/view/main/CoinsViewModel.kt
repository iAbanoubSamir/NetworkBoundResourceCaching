package com.abanoub.caching.ui.view.main

import androidx.lifecycle.*
import com.abanoub.caching.data.remote.api.CoinApi
import com.abanoub.caching.data.entity.Coin
import com.abanoub.caching.data.repo.CoinsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    repository: CoinsRepository
) : ViewModel() {

    val coins = repository.getCoins().asLiveData()

}