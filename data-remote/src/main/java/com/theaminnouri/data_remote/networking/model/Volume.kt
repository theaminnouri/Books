package com.theaminnouri.data_remote.networking.model

import com.google.gson.annotations.SerializedName


data class Volume(
    @SerializedName("kind") var kind: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("etag") var etag: String? = null,
    @SerializedName("selfLink") var selfLink: String? = null,
    @SerializedName("volumeInfo") var volumeInfo: VolumeInfo? = VolumeInfo(),
    @SerializedName("saleInfo") var saleInfo: SaleInfo? = SaleInfo(),
    @SerializedName("accessInfo") var accessInfo: AccessInfo? = AccessInfo()
)
