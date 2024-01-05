package com.theaminnouri.data_remote.networking.model

import com.squareup.moshi.Json


data class PanelizationSummary(
    @Json(name = "containsEpubBubbles") var containsEpubBubbles: Boolean? = null,
    @Json(name = "containsImageBubbles") var containsImageBubbles: Boolean? = null
)
