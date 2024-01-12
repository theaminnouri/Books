package com.theaminnouri.data_remote.networking.model

import com.google.gson.annotations.SerializedName


data class ImageLinks(
    @SerializedName("smallThumbnail") var smallThumbnail: String? = null,
    @SerializedName("thumbnail") var thumbnail: String? = null,
    @SerializedName("small") var small: String? = null,
    @SerializedName("medium") var medium: String? = null,
    @SerializedName("large") var large: String? = null,
    @SerializedName("extraLarge") var extraLarge: String? = null
)
