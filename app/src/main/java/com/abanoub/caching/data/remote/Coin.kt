package com.abanoub.caching.data.remote

import com.google.gson.annotations.SerializedName

data class Coin(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("uid") var uid: String? = null,
    @SerializedName("coin_name") var coinName: String? = null,
    @SerializedName("acronym") var acronym: String? = null,
    @SerializedName("logo") var logo: String? = null
)
