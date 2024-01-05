package com.theaminnouri.data_remote.networking.model

data class Volumes(
    val kind: String? = null,
    val totalItems: Long? = null,
    val items: ArrayList<Volume> = arrayListOf(),
)
