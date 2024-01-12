package com.theaminnouri.data_remote.networking.model

import com.google.gson.annotations.SerializedName


data class Volumes(
    @SerializedName("kind") val kind: String? = null,
    @SerializedName("totalItems") val totalItems: Int? = null,
    @SerializedName("items") val items: List<Volume> = arrayListOf(),
)
