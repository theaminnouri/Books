package com.theaminnouri.data_remote.networking.model

import com.squareup.moshi.Json


data class ImageLinks(
    @Json(name = "smallThumbnail") var smallThumbnail: String? = null,
    @Json(name = "thumbnail") var thumbnail: String? = null,
    @Json(name = "small") var small: String? = null,
    @Json(name = "medium") var medium: String? = null,
    @Json(name = "large") var large: String? = null,
    @Json(name = "extraLarge") var extraLarge: String? = null
)
