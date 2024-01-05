package com.theaminnouri.data_remote.networking.model

import com.squareup.moshi.Json


data class Pdf(
    @Json(name = "isAvailable") var isAvailable: Boolean? = null,
    @Json(name = "acsTokenLink") var acsTokenLink: String? = null
)
