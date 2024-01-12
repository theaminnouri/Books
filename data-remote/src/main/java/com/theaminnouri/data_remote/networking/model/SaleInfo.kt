package com.theaminnouri.data_remote.networking.model

import com.google.gson.annotations.SerializedName


data class SaleInfo(
    @SerializedName("country") var country: String? = null,
    @SerializedName("saleability") var saleability: String? = null,
    @SerializedName("isEbook") var isEbook: Boolean? = null
)
