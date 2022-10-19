package com.abanoub.caching.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abanoub.caching.utils.Constants.COINS_TABLE_NAME
import com.google.gson.annotations.SerializedName

@Entity(tableName = COINS_TABLE_NAME)
data class Coin(
    @SerializedName("id") @PrimaryKey var id: Int? = null,
    @SerializedName("uid") var uid: String? = null,
    @SerializedName("coin_name") var coinName: String? = null,
    @SerializedName("acronym") var acronym: String? = null,
    @SerializedName("logo") var logo: String? = null
)
