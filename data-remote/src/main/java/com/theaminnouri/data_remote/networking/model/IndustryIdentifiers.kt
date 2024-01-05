package com.theaminnouri.data_remote.networking.model

import com.squareup.moshi.Json


data class IndustryIdentifiers(
    @Json(name = "type") var type: String? = null,
    @Json(name = "identifier") var identifier: String? = null
)
