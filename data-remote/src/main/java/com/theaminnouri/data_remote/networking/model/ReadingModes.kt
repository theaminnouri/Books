package com.theaminnouri.data_remote.networking.model

import com.google.gson.annotations.SerializedName


data class ReadingModes(
    @SerializedName("text") var text: Boolean? = null,
    @SerializedName("image") var image: Boolean? = null
)
