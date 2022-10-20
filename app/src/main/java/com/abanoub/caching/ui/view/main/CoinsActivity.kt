package com.abanoub.caching.ui.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.abanoub.caching.R
import com.abanoub.caching.databinding.ActivityCoinsBinding
import com.abanoub.caching.ui.adapter.CoinAdapter
import com.abanoub.caching.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinsActivity : AppCompatActivity() {
    private val viewMode: CoinsViewModel by viewModels()
    private lateinit var binding: ActivityCoinsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coinAdapter = CoinAdapter()

        binding.apply {
            coinsRecycleView.apply {
                adapter = coinAdapter
                layoutManager = LinearLayoutManager(this@CoinsActivity)
                setHasFixedSize(true)
            }

            viewMode.coins.observe(this@CoinsActivity) { resource ->
                coinAdapter.submitList(resource.data)

                loadingProgressBar.isVisible =
                    resource is Resource.Loading && resource.data.isNullOrEmpty()
                errorTextView.isVisible =
                    resource is Resource.Error && resource.data.isNullOrEmpty()
                errorTextView.text = resource.error?.message
            }
        }

    }
}