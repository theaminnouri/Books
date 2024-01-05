package com.theaminnouri.data_remote.networking.model

import com.squareup.moshi.Json


data class Volume(
    @Json(name = "kind") var kind: String? = null,
    @Json(name = "id") var id: String? = null,
    @Json(name = "etag") var etag: String? = null,
    @Json(name = "selfLink") var selfLink: String? = null,
    @Json(name = "volumeInfo") var volumeInfo: VolumeInfo? = VolumeInfo(),
    @Json(name = "saleInfo") var saleInfo: SaleInfo? = SaleInfo(),
    @Json(name = "accessInfo") var accessInfo: AccessInfo? = AccessInfo()
)
