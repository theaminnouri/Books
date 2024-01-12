package com.theaminnouri.data_remote.networking.model

import com.google.gson.annotations.SerializedName


data class Epub(
    @SerializedName("isAvailable") var isAvailable: Boolean? = null
)
