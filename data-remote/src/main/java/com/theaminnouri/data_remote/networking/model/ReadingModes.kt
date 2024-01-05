package com.theaminnouri.data_remote.networking.model

import com.squareup.moshi.Json


data class ReadingModes(
    @Json(name = "text") var text: Boolean? = null,
    @Json(name = "image") var image: Boolean? = null
)
