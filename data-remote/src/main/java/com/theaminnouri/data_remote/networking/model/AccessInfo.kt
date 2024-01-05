package com.theaminnouri.data_remote.networking.model

import com.squareup.moshi.Json


data class AccessInfo (
  @Json(name = "country"                ) var country                : String?  = null,
  @Json(name = "viewability"            ) var viewability            : String?  = null,
  @Json(name = "embeddable"             ) var embeddable             : Boolean? = null,
  @Json(name = "publicDomain"           ) var publicDomain           : Boolean? = null,
  @Json(name = "textToSpeechPermission" ) var textToSpeechPermission : String?  = null,
  @Json(name = "epub"                   ) var epub                   : Epub?    = Epub(),
  @Json(name = "pdf"                    ) var pdf                    : Pdf?     = Pdf(),
  @Json(name = "webReaderLink"          ) var webReaderLink          : String?  = null,
  @Json(name = "accessViewStatus"       ) var accessViewStatus       : String?  = null,
  @Json(name = "quoteSharingAllowed"    ) var quoteSharingAllowed    : Boolean? = null
)
