package com.theaminnouri.data_remote.networking.model

import com.squareup.moshi.Json


data class SaleInfo(
    @Json(name = "country") var country: String? = null,
    @Json(name = "saleability") var saleability: String? = null,
    @Json(name = "isEbook") var isEbook: Boolean? = null
)
