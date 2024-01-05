package com.theaminnouri.data_remote.networking.model

import com.squareup.moshi.Json


data class Epub(
    @Json(name = "isAvailable") var isAvailable: Boolean? = null
)
